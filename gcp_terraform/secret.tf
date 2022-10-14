resource "google_secret_manager_secret" "admin-password" {
  secret_id = "admin-password-id"

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

resource "google_secret_manager_secret_version" "admin-password-version" {
  secret      = google_secret_manager_secret.admin-password.id
  secret_data = "Sup3rS3cur3P@ssw0rd3"
}

data "google_secret_manager_secret_version" "admin-password-version-data" {
  secret  = google_secret_manager_secret.admin-password.name
  version = "1"
}
