resource "google_storage_bucket" "demo-bucket" {
  name     = "${var.app_name_suffix}-bucket"
  location = var.region

  storage_class = "STANDARD" # this is useless, STANDARD is the default value
}
