.DEFAULT_GOAL := help

.PHONY: help setup dev api-dev up down logs clean

help: ## Lista os comandos disponíveis
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "  \033[36m%-15s\033[0m %s\n", $$1, $$2}'

setup: ## Instala dependências JS e gera go.sum
	npm install
	cd apps/api && go mod tidy

dev: ## Inicia o frontend SvelteKit localmente (sem Docker)
	npm run dev

api-dev: ## Inicia a API Go com hot-reload via Air
	cd apps/api && air

up: ## Sobe toda a stack via Docker (produção, porta 80)
	docker compose up -d --build

down: ## Para e remove os containers
	docker compose down

logs: ## Acompanha os logs de todos os serviços
	docker compose logs -f

clean: ## Remove containers, volumes e imagens locais
	docker compose down -v --rmi local
