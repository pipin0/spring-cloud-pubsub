output "connection_name" {
  value = google_sql_database_instance.demo-db-instance.connection_name
}

output "service_account_email_address" {
  value = google_sql_database_instance.demo-db-instance.service_account_email_address
}

output "public_ip_address" {
  value = google_sql_database_instance.demo-db-instance.public_ip_address
}

output "db-admin-password" {
  value     = data.google_secret_manager_secret_version.db-admin-password-version-data.secret_data
  sensitive = true
}
