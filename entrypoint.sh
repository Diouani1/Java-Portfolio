#!/bin/bash
set -e

# Copy local.properties from secret mount to working directory if exists
if [ -f /etc/secrets/local.properties ]; then
  cp /etc/secrets/local.properties /app/local.properties
  echo "✔ local.properties copied to /app/"
else
  echo "⚠️  /etc/secrets/local.properties not found"
fi

# Run the Spring Boot app
exec java -jar app.jar
