resource "google_cloud_run_service" "default" {
  name                       = "demo-pub-sub-run"
  location                   = "europe-west6"
  autogenerate_revision_name = true

  template {
    spec {
      containers {
        image = "gcr.io/vittorio-playground/spring-cloud-pubsub@sha256:8aa0773dd13a399cae55d26a2455aa27d10b3c660df9bebcb4584353c1a71995"
        env {
          name  = "TF_VAR_subscription_name"
          value = "demo-pub-sub-subscription"
        }
        env {
          name  = "TF_VAR_topic_name"
          value = "demo-pub-sub-great-topic"
        }

        resources {
          limits = {
            cpu    = "1000m"
            memory = "1Gi"
          }
        }
      }
    }
  }
}

resource "google_cloud_run_service_iam_member" "public_access" {
  count    = var.allow_public_access ? 1 : 0
  service  = google_cloud_run_service.default.name
  location = google_cloud_run_service.default.location
#  project  = google_cloud_run_service.default.project
  role     = "roles/run.invoker"
  member   = "allUsers"

  depends_on = [
    google_cloud_run_service.default
  ]
}
