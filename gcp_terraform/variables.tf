variable "project" {}

variable "credentials_file" {}

variable "github_owner" {}

variable "github_repository" {}

variable "audio_topic_name" {}

variable "audio_subscription_name" {}

variable "region" {
  default = "europe-west6"
}

variable "zone" {
  default = "europe-west6-c"
}

variable "allow_public_access" {
  type        = bool
  default     = true
  description = "Allow unauthenticated access to the service."
}

variable "app_name_suffix" {
  type        = string
  description = "App name suffix"
  default     = "victor-app"
}
