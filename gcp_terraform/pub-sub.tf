resource "google_pubsub_topic" "demo-topic" {
  name = var.topic_name
}

resource "google_pubsub_subscription" "demo-subscription" {
  name  = var.subscription_name
  topic = google_pubsub_topic.demo-topic.name

  ack_deadline_seconds = 20

  retry_policy {
    minimum_backoff = "10s"
    maximum_backoff = "600s"
  }

  depends_on = [
    google_pubsub_topic.demo-topic
  ]
}
