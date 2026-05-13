FROM golang:1.23-alpine AS builder
WORKDIR /app

COPY apps/api .

RUN go mod tidy && \
    CGO_ENABLED=0 GOOS=linux go build -ldflags="-s -w" -o server ./cmd/server

FROM alpine:3.21 AS runner
RUN apk --no-cache add ca-certificates tzdata

WORKDIR /app
COPY --from=builder /app/server .

EXPOSE 8080
CMD ["./server"]
