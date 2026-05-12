
# Requisitos do Produto — Catálogo Digital de Estabelecimentos

> Documento gerado a partir da prospecção de mercado (`prospecção.md`).
> Concorrentes de referência: Zerofila, Goomer, Menudino.

---

## 1. Visão Geral

Plataforma SaaS multi-tenant que permite a estabelecimentos do setor alimentício (restaurantes, pizzarias, lancherias, bares, confeitarias) publicar seu cardápio digital com suporte a pedidos online — competindo diretamente com Goomer e Zerofila, com diferenciação em experiência desktop, SEO e ferramentas de conversão.

---

## 2. Requisitos Funcionais

### 2.1 Catálogo do Estabelecimento

| ID | Requisito |
|----|-----------|
| F01 | Cada estabelecimento possui uma URL própria no padrão `<slug>.dominio.com.br` |
| F02 | Página do estabelecimento exibe: banner de capa, logo, nome, categoria, horários de funcionamento e status (aberto/fechado) |
| F03 | O cardápio é organizado em seções configuráveis pelo estabelecimento |
| F04 | Cada item do cardápio contém: nome, descrição completa, preço, foto e disponibilidade (ativo/inativo) |
| F05 | Itens podem ter variações (ex: tamanho P/M/G) e complementos/adicionais com preço individual |
| F06 | O estabelecimento pode marcar itens como "Destaque" e "Promoção" |
| F07 | Promoções suportam: desconto percentual, desconto fixo e combos |
| F08 | O cardápio exibe os destaques em carrossel no topo antes das seções |
| F09 | Seções e itens podem ser reordenados via drag-and-drop no painel admin |
| F10 | Itens fora de estoque são exibidos como indisponíveis sem remover do cardápio |

### 2.2 Busca e Navegação

| ID | Requisito |
|----|-----------|
| F11 | Busca com resultados em tempo real a cada caractere digitado (diferencial vs. Zerofila) |
| F12 | Resultados de busca exibidos inline na mesma tela, sem redirecionar para página separada (diferencial vs. Zerofila) |
| F13 | Filtro rápido por categoria clicável na tela de busca |
| F14 | Navbar/select de seções com smooth scroll até a seção correspondente |
| F15 | Âncora na URL para cada seção (ex: `#pizzas`) permitindo compartilhamento direto |

### 2.3 Pedido e Carrinho

| ID | Requisito |
|----|-----------|
| F16 | Ao clicar em um item, uma bottom sheet/modal exibe foto ampliada, descrição, variações, complementos, campo de observações e contador de quantidade |
| F17 | Campo de observações com limite configurável pelo estabelecimento (padrão 180 caracteres) |
| F18 | Carrinho persistido em `localStorage` para não perder itens ao navegar |
| F19 | Revisão do pedido exibe: itens, subtotal, taxa de entrega estimada e total |
| F20 | Suporte a código de cupom com validação em tempo real |
| F21 | Modalidades de recebimento: entrega e retirada no local (configuráveis por estabelecimento) |
| F22 | Cálculo de taxa de entrega por CEP com integração a API de frete ou tabela manual |
| F23 | Tempo estimado de entrega exibido antes da finalização do pedido |

### 2.4 Pagamento

| ID | Requisito |
|----|-----------|
| F24 | Formas de pagamento na entrega: dinheiro (com troco), crédito, débito, voucher alimentação |
| F25 | Pagamento online via Pix (geração de QR Code dinâmico) |
| F26 | Pagamento online via cartão de crédito/débito (integração com gateway: Stripe, PagSeguro ou Mercado Pago) |
| F27 | Solicitação opcional de CPF/CNPJ na nota |

### 2.5 Conta do Consumidor

| ID | Requisito |
|----|-----------|
| F28 | Pedido sem cadastro obrigatório (apenas nome e telefone) |
| F29 | Opção de criar conta para salvar endereços, histórico de pedidos e dados de pagamento |
| F30 | Login via e-mail/senha, Google e número de telefone (OTP via SMS ou WhatsApp) |
| F31 | Histórico de pedidos com opção de "repetir pedido" |

### 2.6 Rastreamento do Pedido

| ID | Requisito |
|----|-----------|
| F32 | Página de status do pedido com etapas: Recebido → Em preparo → Saiu para entrega → Entregue |
| F33 | Notificação de atualização de status via WhatsApp (Business API) ou SMS |
| F34 | Link de acompanhamento enviado ao consumidor após confirmação do pedido |

### 2.7 Avaliações

| ID | Requisito |
|----|-----------|
| F35 | Consumidores podem avaliar o estabelecimento (1–5 estrelas) após entrega confirmada |
| F36 | Avaliações exibidas publicamente na página do estabelecimento com média e total de avaliações |
| F37 | Estabelecimento pode responder avaliações |

### 2.8 Painel Administrativo do Estabelecimento

| ID | Requisito |
|----|-----------|
| F38 | Dashboard com: pedidos do dia, faturamento, ticket médio e avaliação média |
| F39 | Gestão completa do cardápio (seções, itens, fotos, preços, disponibilidade) |
| F40 | Gestão de pedidos em tempo real com notificação sonora e visual para novos pedidos |
| F41 | Impressão ou envio automático do pedido para impressora térmica (protocolo ESC/POS) |
| F42 | Configuração de horários de funcionamento por dia da semana |
| F43 | Configuração de áreas de entrega (raio em km ou lista de bairros) com taxas correspondentes |
| F44 | Relatórios exportáveis em CSV/PDF: vendas por período, itens mais vendidos, cupons utilizados |
| F45 | Gestão de cupons de desconto com validade, limite de usos e valor mínimo de pedido |
| F46 | Upload em lote de itens via planilha CSV |

### 2.9 Diretório Público (diferencial vs. concorrentes ponto a ponto)

| ID | Requisito |
|----|-----------|
| F47 | Página de diretório em `dominio.com.br/ribeirao-preto` listando todos os estabelecimentos da cidade |
| F48 | Filtro por categoria (pizza, hambúrguer, japonês, etc.), faixa de preço e avaliação |
| F49 | Ordenação por: relevância, avaliação, tempo de entrega, menor taxa |
| F50 | Cada card do diretório exibe: foto, nome, categoria, avaliação, tempo e taxa estimados |

---

## 3. Requisitos Não-Funcionais

### 3.1 Interface e Experiência

| ID | Requisito |
|----|-----------|
| NF01 | Layout responsivo: mobile-first com experiência desktop **completamente funcional** — ocupar toda a largura disponível acima de 768px (gap crítico de Goomer e Zerofila) |
| NF02 | First Contentful Paint < 1,5s em conexão 4G |
| NF03 | Imagens servidas em formato WebP com lazy loading |
| NF04 | Smooth scroll nativo entre seções do cardápio |
| NF05 | Bottom sheet para detalhes do item com animação de entrada de 200ms |
| NF06 | Tema claro e escuro configurável por estabelecimento (cor primária customizável) |
| NF07 | Suporte a PWA: instalável na tela inicial do celular, funciona offline para leitura do cardápio |

### 3.2 SEO e Descobrimento

| ID | Requisito |
|----|-----------|
| NF08 | Cada página de estabelecimento com meta tags Open Graph e Twitter Card para compartilhamento em redes sociais |
| NF09 | Structured data (JSON-LD) seguindo schema.org `Restaurant` e `Menu` para indexação rica no Google |
| NF10 | URLs canônicas, sitemap.xml e robots.txt gerados automaticamente |
| NF11 | SSR (Server-Side Rendering) ou SSG para as páginas públicas do cardápio |

### 3.3 Confiabilidade e Escala

| ID | Requisito |
|----|-----------|
| NF12 | Disponibilidade de 99,9% (uptime mensal ≤ 43min de downtime) |
| NF13 | Pedidos processados com idempotência — reenvio não duplica pedido |
| NF14 | Multi-tenant isolado: dados de um estabelecimento não vazam para outro |
| NF15 | Backup diário automático do banco de dados com retenção de 30 dias |

### 3.4 Segurança

| ID | Requisito |
|----|-----------|
| NF16 | HTTPS obrigatório em todos os domínios e subdomínios |
| NF17 | Dados de cartão nunca armazenados localmente — tokenização via gateway |
| NF18 | Rate limiting nas rotas de pedido e autenticação |
| NF19 | LGPD: política de privacidade, consentimento de cookies e endpoint de exclusão de dados |

---

## 4. Diferenciais Competitivos

Com base nas lacunas identificadas na prospecção:

| # | Lacuna do Concorrente | Nossa Solução |
|---|----------------------|---------------|
| D1 | Goomer e Zerofila são mobile-only, desktop ocupa apenas o centro | Layout totalmente responsivo com colunas em desktop |
| D2 | Zerofila não tem busca em tempo real | Busca reativa a cada keystroke com resultados inline |
| D3 | Zerofila ocupa tela inteira apenas para um campo de busca | Busca em painel lateral ou overlay compacto |
| D4 | Goomer não exibe contato facilmente | Número de telefone e WhatsApp clicável visível no header |
| D5 | Zerofila parece ser apenas cardápio (sem pedido online) | Fluxo completo de pedido integrado |
| D6 | Nenhum tem diretório público por cidade com SEO forte | Diretório indexável no Google por cidade/categoria |
| D7 | Sem notificações proativas ao consumidor | Status do pedido via WhatsApp |
| D8 | Sem avaliações nos concorrentes estudados | Sistema de avaliação pós-entrega |

---

## 5. Fora de Escopo (v1)

- Aplicativo nativo iOS/Android (PWA cobre o caso de uso inicial)
- Integração com marketplaces externos (iFood, Rappi)
- Sistema de gestão de mesas (reservas, comanda por mesa)
- Programa de fidelidade/pontos
- Múltiplos idiomas

---

## 6. Integrações Externas Necessárias

| Serviço | Finalidade |
|---------|-----------|
| ViaCEP / Google Maps | Validação de CEP e cálculo de frete |
| Mercado Pago ou PagSeguro | Gateway de pagamento (Pix + cartão) |
| WhatsApp Business API | Notificações de status do pedido |
| Cloudflare R2 ou AWS S3 | Armazenamento de imagens dos produtos |
| Resend ou SendGrid | E-mails transacionais |
