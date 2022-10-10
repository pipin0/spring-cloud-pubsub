resource "google_cloudbuild_trigger" "demo-pub-sub-build-trigger" {
  project     = var.project
  description = "Build trigger for demo pub/sub project"
  name        = "demo-pub-sub"

  github {
    owner = var.github_owner
    name  = var.github_repository

    push {
      branch = "master"
    }
  }

  build {
    images  = ["gcr.io/$PROJECT_ID/$REPO_NAME:$COMMIT_SHA"]
    timeout = "599s"
    step {
      name = "gcr.io/cloud-builders/docker"
      args = ["build", "-t", "gcr.io/$PROJECT_ID/$REPO_NAME:$COMMIT_SHA", "-f", "Dockerfile", "."]
    }
  }
}
