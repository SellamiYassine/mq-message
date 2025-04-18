## Prérequis

- Docker & Docker Compose
- Java 17 (si build local sans Docker)
- Node.js 20+ et npm (si build local sans Docker)
- Maven 3.8+ (si build local sans Docker)

---

## Lancer le projet avec Docker

1. Cloner le dépôt :
```bash
git clone https://github.com/ton-utilisateur/ton-projet.git
cd ton-projet
./mvnw clean install -DskipTests
cd mq-frontend
npm install --force
npm run build
cd ..
docker compose up --build

