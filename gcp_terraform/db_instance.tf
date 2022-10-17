resource "google_sql_database_instance" "demo-db-instance" {
  name             = "${var.app_name_suffix}-db-instance"
  database_version = "POSTGRES_14"
  region           = var.region

  settings {
    availability_type = "ZONAL"

    tier = "db-f1-micro"

    ip_configuration {
      ipv4_enabled = true
    }

    backup_configuration {
      enabled = false
    }
  }
}

resource "google_sql_database" "database" {
  name     = "fantastic-db"
  instance = google_sql_database_instance.demo-db-instance.name
}

# This is not strictly necessary but we can use this user to connect to the DB
resource "google_sql_user" "a-user" {
  name     = "aaa"
  instance = google_sql_database_instance.demo-db-instance.name
  password = google_secret_manager_secret_version.db-admin-password-version.secret_data

  depends_on = [
    google_sql_database_instance.demo-db-instance
  ]
}
