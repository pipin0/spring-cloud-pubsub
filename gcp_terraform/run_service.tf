resource "google_cloud_run_service" "default" {
  name                       = "${var.app_name_suffix}-run"
  location                   = var.region
  autogenerate_revision_name = true

  template {
    spec {
      containers {
        image = "gcr.io/${var.project}/${var.github_repository}:latest"

        env {
          name  = "TF_VAR_topic_name"
          value = google_pubsub_topic.demo-topic.name
        }
        env {
          name  = "TF_VAR_subscription_name"
          value = google_pubsub_subscription.demo-subscription.name
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
    google_pubsub_topic.demo-topic,
    google_pubsub_subscription.demo-subscription,
    google_sql_database_instance.demo-db-instance
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
