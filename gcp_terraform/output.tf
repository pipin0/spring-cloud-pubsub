output "connection_name" {
  value = google_sql_database_instance.demo-db-instance.connection_name
}

output "service_account_email_address" {
  value = google_sql_database_instance.demo-db-instance.service_account_email_address
}

output "public_ip_address" {
  value = google_sql_database_instance.demo-db-instance.public_ip_address
}
