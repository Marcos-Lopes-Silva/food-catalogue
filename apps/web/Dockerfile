FROM node:22-alpine AS builder
WORKDIR /app

RUN corepack enable && corepack prepare pnpm@9.15.0 --activate

COPY package.json pnpm-workspace.yaml pnpm-lock.yaml ./
COPY apps/web/package.json ./apps/web/package.json
RUN pnpm install --filter @food-catalogue/web --frozen-lockfile

COPY apps/web ./apps/web
WORKDIR /app/apps/web
RUN pnpm build

FROM node:22-alpine AS runner
WORKDIR /app

ENV NODE_ENV=production
ENV HOST=0.0.0.0
ENV PORT=3000

COPY --from=builder /app/apps/web/build ./build
COPY --from=builder /app/apps/web/package.json ./package.json

EXPOSE 3000
CMD ["node", "build"]
