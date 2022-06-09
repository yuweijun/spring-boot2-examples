# spring-boot2-vault

## resources

https://spring.io/guides/gs/vault-config/#initial

## start server

$ export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
$ export VAULT_ADDR="http://127.0.0.1:8200"

$ vault server --dev --dev-root-token-id="$VAULT_TOKEN"

## vault web ui

access web url: http://localhost:8200/ui/
with token: 00000000-0000-0000-0000-000000000000

## add key/value in another terminal

$ export VAULT_TOKEN="00000000-0000-0000-0000-000000000000"
$ export VAULT_ADDR="http://127.0.0.1:8200"

$ vault kv put secret/spring-boot2-vault com.example.username=demouser com.example.password=demopassword
$ vault kv put secret/spring-boot2-vault/cloud com.example.username=clouduser com.example.password=cloudpassword

# spring spring-boot-starter-actuator configuration for endpoints

https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-endpoints

