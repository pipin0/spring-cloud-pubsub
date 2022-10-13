resource "google_storage_bucket" "demo_bucket" {
  name     = "demo-bucket-vittorio"
  location = "europe-west6"

  storage_class = "STANDARD" # this is useless, STANDARD is the default value
}
