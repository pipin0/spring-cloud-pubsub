variable "project" {}

variable "credentials_file" {}

variable "github_owner" {}

variable "github_repository" {}

variable "topic_name" {}

variable "subscription_name" {}

variable "region" {
  default = "us-central1"
}

variable "zone" {
  default = "us-central1-c"
}

variable "allow_public_access" {
  type        = bool
  default     = true
  description = "Allow unauthenticated access to the service."
}
