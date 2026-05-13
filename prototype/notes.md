# Sobre o protótipo

## Establishment

```json
{
    "name": "Pizzaria Sol & Sabor",
    "category": "Pizza, Lanches e Sobremesas",
    "status": "Aberto agora",
    "hours": "Seg-Sex 18:00–23:30 · Sáb-Dom 18:00–00:00",
    "address": "R. das Flores, 123 · Ribeirão Preto",
    "phone": "+55 (16) 99999-9999",
    "whatsapp": "+55 (16) 99999-9999",
    "logo": "https://via.placeholder.com/120x120?text=Logo",
    "banner": "https://via.placeholder.com/1200x420?text=Banner"
}
```

https://schema.org/FoodEstablishment

- address pode sim ser apenas um texto
- `hours` deveria se chamar `openingHours`
- `priceRange` também seria pertinente
- `servesCuisine` também seria pertinente

```json
{
  "@context": "https://schema.org",
  "@type": "Restaurant",
  "address": {
    "@type": "PostalAddress",
    "addressLocality": "Sunnyvale",
    "addressRegion": "CA",
    "postalCode": "94086",
    "streetAddress": "1901 Lemur Ave"
  },
  "aggregateRating": {
    "@type": "AggregateRating",
    "ratingValue": "4",
    "reviewCount": "250"
  },
  "name": "GreatFood",
  "openingHours": [
    "Mo-Sa 11:00-14:30",
    "Mo-Th 17:00-21:30",
    "Fr-Sa 17:00-22:00"
  ],
  "priceRange": "$$",
  "servesCuisine": [
    "Middle Eastern",
    "Mediterranean"
  ],
  "telephone": "(408) 714-1489",
  "url": "http://www.greatfood.com"
}
```

## Sections

Essa estrutura no json se assemelha e poderia ser identica à [hasMenu](https://schema.org/Menu).

Note a semelhança

```json

   "@context":"https://schema.org",
   "@type":"Restaurant",
   "url":"http://www.somerestaurant.com",
   "name":"Some Restaurant",
   "description":"This is the Some Restaurant located on 345 Spear St. San Francisco, 94105 CA. It serves Indian-Mexican fusion cuisine",
   "servesCuisine":[
      "Indian-Mexican Fusion"
   ],
   "hasMenu":{
      "@type":"Menu",
      "hasMenuSection":{
         "@type":"MenuSection",
         "name":"Tacos",
         "description":"Tacos inspired by India cuisine.",
         "image":[
            "https://somerestaurant.com/some_tacos.jpg",
            "https://somerestaurant.com/more_tacos.jpg"
         ],
         "offers":{
            "@type":"Offer",
            "availabilityEnds":"2017-03-02T08:22:00",
            "availabilityStarts":"2017-03-02T08:22:00"
         },
         "hasMenuItem":{
            "@type":"MenuItem",
            "name":"Aloo Gobi Taco",
            "description":"Mexico City-style street corn tortilla taco filled with a flavorful mixture of mildly south Indian spiced cauliflower, potato, tomato, onions and bell peppers.",
            "offers":{
               "@type":"Offer",
               "price":"3.50",
               "priceCurrency":"USD"
            },
            "nutrition":{
               "@type":"NutritionInformation",
               "calories":"170 calories",
               "fatContent":"3 grams",
               "fiberContent":"2 grams",
               "proteinContent":"4 grams"
            },
            "suitableForDiet":"https://schema.org/GlutenFreeDiet"
         }
      },
      "inLanguage":"English"
   }
}
```