package middleware

import (
	"net/http"
	"os"
	"strings"

	"github.com/labstack/echo/v4"
	"github.com/labstack/echo/v4/middleware"
)

func CORS() echo.MiddlewareFunc {
	origins := os.Getenv("ALLOWED_ORIGINS")
	if origins == "" {
		origins = "*"
	}

	return middleware.CORSWithConfig(middleware.CORSConfig{
		AllowOrigins: strings.Split(origins, ","),
		AllowMethods: []string{
			http.MethodGet, http.MethodPost, http.MethodPut,
			http.MethodPatch, http.MethodDelete, http.MethodOptions,
		},
		AllowHeaders: []string{
			echo.HeaderOrigin, echo.HeaderContentType, echo.HeaderAuthorization,
		},
	})
}
