export interface SampleData {
  title: string;
  establishment: Establishment;
  url: string;
  hasMenu: HasMenu;
  filters: string[];
  highlights: Highlight[];
  sections: Section[];
  orderSummary: OrderSummary;
  footer: Footer;
}

export interface Establishment {
  name: string;
  category: string;
  status: string;
  openingHours: string[];
  priceRange: string;
  servesCuisine: string[];
  address: string;
  phone: string;
  whatsapp: string;
  logo: string;
  banner: string;
}

export interface HasMenu {
  '@type': string;
  hasMenuSection: MenuSectionJSON[];
}

export interface MenuSectionJSON {
  '@type': string;
  name: string;
  hasMenuItem: MenuItemJSON[];
}

export interface MenuItemJSON {
  '@type': string;
  name: string;
  description: string;
  offers: Offer;
}

export interface Offer {
  '@type': string;
  price: string;
  priceCurrency: string;
}

export interface Highlight {
  title: string;
  subtitle: string;
  price: string;
}

export interface Section {
  id: string;
  name: string;
  items: Item[];
}

export interface Item {
  name: string;
  description: string;
  price: string;
  status: string;
  badge?: string;
  variation: string;
}

export interface OrderSummary {
  subtotal: string;
  delivery: string;
  total: string;
  pickup: string;
  payment: string;
}

export interface Footer {
  city: string;
  directoryUrl: string;
}
