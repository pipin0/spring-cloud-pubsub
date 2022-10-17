resource "google_secret_manager_secret" "db-admin-password" {
  secret_id = "db-admin-password-id"

  replication {
    user_managed {
      replicas {
        location = "europe-west1"
      }
      replicas {
        location = "europe-west4"
      }
    }
  }
}

resource "google_secret_manager_secret_version" "db-admin-password-version" {
  secret      = google_secret_manager_secret.db-admin-password.id
  secret_data = "Sup3rS3cur3P@ssw0rd3"
}

data "google_secret_manager_secret_version" "db-admin-password-version-data" {
  secret  = google_secret_manager_secret.db-admin-password.name
  version = "1"
}
