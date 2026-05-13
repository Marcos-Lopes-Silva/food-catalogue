package main

import (
	"log"
	"os"

	"food-catalogue/api/internal/handler"
	custommiddleware "food-catalogue/api/internal/middleware"

	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
)

func main() {
	e := echo.New()
	e.HideBanner = true

	e.Use(middleware.Logger())
	e.Use(middleware.Recover())
	e.Use(custommiddleware.CORS())

	api := e.Group("/api")
	api.GET("/health", handler.Health)

	port := os.Getenv("PORT")
	if port == "" {
		port = "8080"
	}

	log.Printf("API iniciada em :%s", port)
	if err := e.Start(":" + port); err != nil {
		log.Fatal(err)
	}
}
