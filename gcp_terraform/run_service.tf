resource "google_cloud_run_service" "default" {
  name                       = "demo-pub-sub-run"
  location                   = "europe-west6"
  autogenerate_revision_name = true

  template {
    spec {
      containers {
        image = "gcr.io/${var.project}/${var.github_repository}"

        env {
          name  = "TF_VAR_topic_name"
          value = google_pubsub_topic.demo-pub-sub-topic.name
        }
        env {
          name  = "TF_VAR_subscription_name"
          value = google_pubsub_subscription.demo-pub-sub-subscription.name
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

  depends_on = [
    google_pubsub_topic.demo-pub-sub-topic,
    google_pubsub_subscription.demo-pub-sub-subscription
  ]
}

resource "google_cloud_run_service_iam_member" "public_access" {
  count    = var.allow_public_access ? 1 : 0
  service  = google_cloud_run_service.default.name
  location = google_cloud_run_service.default.location
  role     = "roles/run.invoker"
  member   = "allUsers"

  depends_on = [
    google_cloud_run_service.default
  ]
}
