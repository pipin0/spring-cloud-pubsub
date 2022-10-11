**INFO**

* to start the app
    * locally, i.e. for dev, it is necessary to set
        * google account credentials: _"spring.cloud.gcp.credentials.location"_
        * project id: _"spring.cloud.gcp.project-id"
    * in "Cloud Run" via Terraform, simply remove these variables (GCP uses the context)

* to share values (i.e. project id, topic, subscription, etc.) it is possible to use environment variables.
  <br/>
  Terraform will read all those variables starting by _"TF_VAR\_"_
