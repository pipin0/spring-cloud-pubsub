**INFO**

* to start the app
    * locally, i.e. for dev, it is necessary to set
        * google account credentials: _"spring.cloud.gcp.credentials.location"_
        * project id: _"spring.cloud.gcp.project-id"
    * in "Cloud Run" via Terraform, simply remove these variables (GCP uses the context)

* Terraform reads environment variables starting by _"TF_VAR\_"_.
