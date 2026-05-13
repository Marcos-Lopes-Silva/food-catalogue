package main

import (
	_ "embed"
	"encoding/json"
	"fmt"
	"html/template"
	"net/http"
	"os"
)

/**
Isso aqui é só pra renderizar o template index.html com base no Json.
Atualizando tanto o json quanto o template vai atualizar o resultado ao atualizar a página.
*/

func getData() map[string]any {
	data := map[string]any{}
	file, err := os.Open("sample-data.json")
	if err != nil {
		panic(err)
	}
	defer file.Close()

	err = json.NewDecoder(file).Decode(&data)
	if err != nil {
		panic(err)
	}
	return data
}

func main() {

	fmt.Println("Listening on localhost:8080")
	http.ListenAndServe(":8080", http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		tmpl := template.Must(template.ParseFiles("index.html"))
		data := getData()
		if err := tmpl.Execute(w, data); err != nil {
			panic(err)
		}
	}))
}
