package models

type Data struct {
	Title         string        `json:"title"`
	Establishment Establishment `json:"establishment"`
	URL           string        `json:"url"`
	HasMenu       Menu          `json:"hasMenu"`
	Filters       []string      `json:"filters"`
	Highlights    []Highlight   `json:"highlights"`
	Sections      []Section     `json:"sections"`
	OrderSummary  OrderSummary  `json:"orderSummary"`
	Footer        Footer        `json:"footer"`
}

type Establishment struct {
	Name          string   `json:"name"`
	Category      string   `json:"category"`
	Status        string   `json:"status"`
	OpeningHours  []string `json:"openingHours"`
	PriceRange    string   `json:"priceRange"`
	ServesCuisine []string `json:"servesCuisine"`
	Address       string   `json:"address"`
	Phone         string   `json:"phone"`
	WhatsApp      string   `json:"whatsapp"`
	Logo          string   `json:"logo"`
	Banner        string   `json:"banner"`
}

type Menu struct {
	Type           string            `json:"@type"`
	HasMenuSection []MenuSectionJSON `json:"hasMenuSection"`
}

type MenuSectionJSON struct {
	Type        string         `json:"@type"`
	Name        string         `json:"name"`
	HasMenuItem []MenuItemJSON `json:"hasMenuItem"`
}

type MenuItemJSON struct {
	Type        string `json:"@type"`
	Name        string `json:"name"`
	Description string `json:"description"`
	Offers      Offer  `json:"offers"`
}

type Offer struct {
	Type          string `json:"@type"`
	Price         string `json:"price"`
	PriceCurrency string `json:"priceCurrency"`
}

type Highlight struct {
	Title    string `json:"title"`
	Subtitle string `json:"subtitle"`
	Price    string `json:"price"`
}

type Section struct {
	ID    string `json:"id"`
	Name  string `json:"name"`
	Items []Item `json:"items"`
}

type Item struct {
	Name        string `json:"name"`
	Description string `json:"description"`
	Price       string `json:"price"`
	Status      string `json:"status"`
	Badge       string `json:"badge,omitempty"`
	Variation   string `json:"variation"`
}

type OrderSummary struct {
	Subtotal string `json:"subtotal"`
	Delivery string `json:"delivery"`
	Total    string `json:"total"`
	Pickup   string `json:"pickup"`
	Payment  string `json:"payment"`
}

type Footer struct {
	City         string `json:"city"`
	DirectoryURL string `json:"directoryUrl"`
}
