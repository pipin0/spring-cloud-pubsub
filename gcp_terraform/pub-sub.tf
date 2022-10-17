resource "google_pubsub_topic" "audio-topic" {
  name = var.audio_topic_name
}

resource "google_pubsub_subscription" "audio-subscription" {
  name  = var.audio_subscription_name
  topic = google_pubsub_topic.audio-topic.name

  ack_deadline_seconds = 30

  retry_policy {
    minimum_backoff = "10s"
    maximum_backoff = "600s"
  }

  depends_on = [
    google_pubsub_topic.audio-topic
  ]
}

resource "google_pubsub_topic" "demo-topic" {
  name = "demo-topic"
}

resource "google_pubsub_subscription" "demo-subscription" {
  name  = "demo-subscription"
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
