resource "google_secret_manager_secret" "db-admin-password" {
  secret_id = "db-admin-password"

  replication {
    automatic = true
  }
}

resource "google_secret_manager_secret_version" "db-admin-password-1" {
  secret      = google_secret_manager_secret.db-admin-password.id
  secret_data = "Sup3rS3cur3P@ssw0rd3"
}

data "google_secret_manager_secret_version" "db-admin-password-data" {
  secret = google_secret_manager_secret.db-admin-password.secret_id
}
