# Setup

## Stack

| Camada | Tecnologia |
|--------|-----------|
| Frontend | SvelteKit 5 + TypeScript |
| Backend | Go 1.23 + Echo v4 |
| Proxy | Nginx |
| Monorepo | pnpm workspaces |

## Pré-requisitos

- [Node.js 22+](https://nodejs.org)
- [pnpm 9+](https://pnpm.io/installation) — `npm install -g pnpm`
- [Go 1.23+](https://go.dev/dl/)
- [Docker + Docker Compose](https://docs.docker.com/get-docker/)
- [Air](https://github.com/air-verse/air) (hot-reload Go) — `go install github.com/air-verse/air@latest`

## Primeira vez

```sh
cp .env.example .env
make setup
```

`make setup` instala as dependências JS e gera o `go.sum`.

## Desenvolvimento local

```sh
# Terminal 1 — SvelteKit em localhost:3000
make dev

# Terminal 2 — API Go em localhost:8080 (com hot-reload)
make api-dev
```

O Vite já está configurado para fazer proxy de `/api/*` para `localhost:8080`, então não é necessário configurar CORS manualmente em dev.

## Docker (produção / acesso externo)

```sh
make up
```

Sobe três containers via Docker Compose:

| Container | Porta interna | Descrição |
|-----------|--------------|-----------|
| nginx | 80 (exposta) | Reverse proxy — entrada única |
| web | 3000 | SvelteKit (adapter-node) |
| api | 8080 | Go + Echo |

Roteamento do nginx:
- `http://<host>/api/*` → API Go
- `http://<host>/*` → SvelteKit

Para acesso externo na rede local, libere a porta 80 no firewall do Windows:

```sh
netsh advfirewall firewall add rule name="food-catalogue" dir=in action=allow protocol=TCP localport=80
```

### Outros comandos Docker

```sh
make down    # para os containers
make logs    # acompanha os logs em tempo real
make clean   # remove containers, volumes e imagens locais
```

## Variáveis de ambiente

Copie `.env.example` para `.env` e preencha os valores. As principais para começar:

| Variável | Descrição |
|----------|-----------|
| `DATABASE_URL` | Connection string do PostgreSQL |
| `JWT_SECRET` | Segredo para assinar tokens |
| `ALLOWED_ORIGINS` | Origens permitidas no CORS (ex: `https://meusite.com`) |

## Estrutura do projeto

```
apps/
  web/          SvelteKit — frontend + SSR
  api/          Go + Echo — API REST
nginx/          Configuração do reverse proxy
```
