A ideia aqui é pegar todas as empresas que **já utilizam** cardápios digitais e ver oq elas gostam ou não gostam de cada produto. Pra isso o primeiro passo é ver quais são esses cardapios e a partir deles encontrar as empresas

# Em ribeirão preto

## Standalone (a propria empresa tem seu cardápio)
- https://www.californiapizzariarp.com.br/cardapio/
- https://www.pizzariatresirmaos.com.br/faca-seu-pedido

## Alternativas do IFood (sites que agregam vários cardápios)
- https://www.menudino.com/delivery/ribeirao-preto-sp

## Possuem subdomínios para cada restaurante 

- pedido.anota.ai (não usa subdonínio, todos tem esse link)
  Ele usa algum tipo de estado interno para saber qual o restaurante (uma merda)
- waymenu.com.br/menu/<NOME_DA_LOJA>
- deliveryapp.neemo.com.br/delivery/<ID_DA_LOJA>
- livemenu.app/menu/<ID_DA_LOJA>
- pedir.delivery/app/<NOME_DA_LOJA>
- <dominio>.goome.app (O GOAT)
- www.duogourmet.com.br/restaurantes/ribeirao-preto/<NOME_DA_LOJA>
- <dominio>.zerofila.com.br

# Proximo passo

Agora eu preciso anotas todas as features dos principais sites para ter uma noção da expectativa dos clientes desses sites. Tendo a lista dessas features eu posso criar um questionário personalizado para entender o impacto delas.

Quais são os cardápios mais relevantes?

- www.menudino.com (uma alternativa forte ao IFood)
- <dominio>.goomer.app
- <dominio>.zerofila.com.br

Goome é grande, amplamente conhecido, vale a pena estudar
Zerofila se parece muito com o que eu pretendo fazer
Menudino gigante, muitas cidades, se parece muito com IFood

# Alvos

## Zerofila
```
festivaldorocambolecotipora.zerofila.com.br
floresbluesjazzfestival.zerofila.com.br
ateliesinergia.zerofila.com.br
festipizza.zerofila.com.br
hedkandi.zerofila.com.br
sicredi.zerofila.com.br
kerbev.zerofila.com.br
www.zerofila.com.br
xisdovini-saofrancisco.zerofila.com.br
cooperativa.zerofila.com.br
festivaldeculturaegastronomiadegramado.zerofila.com.br
p47.zerofila.com.br
eggies.zerofila.com.br
ccubo.zerofila.com.br
fornerianapolitana.zerofila.com.br
caldasrodeo.zerofila.com.br
grillburger.zerofila.com.br
bendita-hamburgueria.zerofila.com.br
bailedemascaras.zerofila.com.br
festadabergamota.zerofila.com.br
festanacionaldomoranguinho.zerofila.com.br
xisdovini-trescoroas.zerofila.com.br
meurodeio.zerofila.com.br
yoo-wines.zerofila.com.br
festivalvaledosvinhedos.zerofila.com.br
cardapio-eggiescriciuma.zerofila.com.br
dev.zerofila.com.br
materiais.zerofila.com.br
miolasmashburger.zerofila.com.br
relatoriozf.zerofila.com.br
venezianospubcafe.zerofila.com.br
eggiespassofundo.zerofila.com.br
mandinhonh.zerofila.com.br
boomfazbem.zerofila.com.br
botecobrazukis2.zerofila.com.br
cikolata-encomendas.zerofila.com.br
spy-bar.zerofila.com.br
boaz.zerofila.com.br
residenzacozinhabar.zerofila.com.br
cadastro-evento.zerofila.com.br
meajuda.zerofila.com.br
nosferatu.zerofila.com.br
ordeo-garden.zerofila.com.br
revendas.zerofila.com.br
sacadabeach.zerofila.com.br
```

### Telefones captados
https://ateliesinergia.zerofila.com.br
(54) 99248-2761
https://xisdovini-saofrancisco.zerofila.com.br
(54) 99927-7132
https://eggies.zerofila.com.br
(51) 99677-4344
https://fornerianapolitana.zerofila.com.br
(11) 5096-1644
https://grillburger.zerofila.com.br
67998856732
https://bendita-hamburgueria.zerofila.com.br
(54) 3538-6500
https://xisdovini-trescoroas.zerofila.com.br
(51) 3546-2086
https://yoo-wines.zerofila.com.br
(54) 9927-7001

### Características do software
Todos são iguais

- Focado **exclusivamente** em mobile
  - Ao utilizar em modo desktop, segue ocupando apenas o centro da tela
    - Isso não afeta muito negativamente a experiencia de usuário mas poderia ser melhor
- Baner mostrando a frente da loja logo no topo do site
- A logo do site aparece em um circulo logo em frente ao baner fazendo a transição para o cardápio em sí
- O nome do restaurante é apresentado logo a baixo da logo
- Segue então um carousel apresentando destaques e promoções
- Destaques são apresentados também em formato de cards antes do menu propriamente
- Uma navbar onde cada sessão do cardapio é um botão
  - Ao clicar em um botão a página rola de forma suave até a sessão do cardápio
- Cada sessão do cardápio possui um título seguido dos produtos
- Cada item possui uma imagem do produto à esquerda, o nome do produto, o preço e optativamente uma descrição do produto
- Fixado a baixo há 3 opções:
  - Busca
    - É necessário digitar o nome e então pesquisar, as buscas não são apresentadas automaticamente durante a pesquisa.
    - Para apresentar a barra de buscas a tela inteira é ocupada apenas para 1 input, o resto do espaço não é utilizado para os resultados
    - Há 2 botões: Lupa e aplicar que fazem o mesmo
  - Home
    - Ao clicar recarrega a página
  - Contato
    - Ao clicar apresenta o baner por inteiro com o nome do restaurante por cima, os horários de funcionamento, endereço e telefone
- Ao clicar no item é apresentada a imagem do prodto maior, o título a abixo
  - Não parece ter nada relacionado à possibilidade de se comprar o produto, provavelmente é programado apenas para ser utilizado no bar a partir de um QR code

## Goomer

```
brendan-house.goomer.app
brie-to-me-1.goomer.app
naturelo-mundo-fitness.goomer.app
o-de-casa-hostel-bar.goomer.app
papa-rica-itu.goomer.app
papa-rica-porto-feliz.goomer.app
srcacaodoces.goomer.app
truefood-natal.goomer.app
bordo-gastro-vino.goomer.app
mesa-bar-e-restaurante.goomer.app
pudimdabia.goomer.app
sottozero-pizzeria.goomer.app
thaisadmiraldoceria.goomer.app
brodoristoranti.goomer.app
karnescom.goomer.app
sushi-food-jundiai.goomer.app
torta-delirio.goomer.app
luiz-cafe-conceito.goomer.app
2mbronzeura.goomer.app
430-gradi-indaiatuba.goomer.app
acai-ouro-negro.goomer.app
donna-olinda-delivery.goomer.app
kranfo-restaurante.goomer.app
papa-rica-indaiatuba.goomer.app
recreio.goomer.app
a-doce-formiga-confeitaria.goomer.app
aquela-parme-asa-sul.goomer.app
cheiroverdejuquehy.goomer.app
japanhouse.goomer.app
abaraje-entrega-absurdamente-reduzida.goomer.app
abaraje-evento.goomer.app
evento-reencontrar-mundo-ok-kodomo-no-sono.goomer.app
famliacosta.goomer.app
madame-formiga-6.goomer.app
7-pizzas.goomer.app
abacazo-shopping-barigui.goomer.app
abacazo-shopping-palladium.goomer.app
acai.goomer.app
acai-no-copo-guaju.goomer.app
ohana-browneria.goomer.app
cafe-ilha.goomer.app
docce-cheesecake.goomer.app
galo-branco.goomer.app
padaria-jardim-do-trigo.goomer.app
reidochurrasco.goomer.app
atelie-lotus.goomer.app
caldos-dona-maria.goomer.app
burger-land.goomer.app
do-digo-macarons.goomer.app
encomendasdaconfeito.goomer.app
gilburger.goomer.app
restaurante-sao-bento-assis.goomer.app
tortas-do-mundo.goomer.app
varandas-marmitas-fit.goomer.app
a-banca-shop-moema.goomer.app
apetipet.goomer.app
cozinhatemperodavo.goomer.app
a-porteira-restaurante.goomer.app
abaraje-da-monica.goomer.app
academia-do-acai.goomer.app
cervejaria-rasen.goomer.app
japon-delivery.goomer.app
pescados-na-brasa.goomer.app
pris-cake-salgados-doces.goomer.app
prodieta.goomer.app
carolate.goomer.app
expressocuiabar.goomer.app
pedidoscantina.goomer.app
24do4.goomer.app
aai-suco-delivery.goomer.app
cachorro-do-bonfa.goomer.app
santo-pesto.goomer.app
tabacowtabacaria.goomer.app
www.goomer.app
acai-do-tio-1.goomer.app
api.goomer.app
da-roca-bolos-caseiros.goomer.app
lievito-pizzaria.goomer.app
mica-chocolates.goomer.app
nosh.goomer.app
piri-confeitaria.goomer.app
2mbronzeba.goomer.app
aquela-parme-brasilia-df-lago-sul.goomer.app
bykim.goomer.app
o-sabor-do-sonho.goomer.app
portocafeco.goomer.app
a-fonte-tapstation-barra.goomer.app
acai-da-hora-delivery2.goomer.app
fox-bbq.goomer.app
loja-cowpig.goomer.app
mamute-burgers.goomer.app
n8n.goomer.app
baiao-de-dois-sjm.goomer.app
fomedemonstersbullcasaburger.goomer.app
jesuino-brilhante.goomer.app
pitlord-defumados.goomer.app
viva-paleteria.goomer.app
yes-gourmet.goomer.app
bacanas-burguer.goomer.app
greenburger.goomer.app
n8n-ovh.goomer.app
202burguerartesanal.goomer.app
4hops.goomer.app
aa-wine-experience.goomer.app
doceriameueseu.goomer.app
mercearia-paraopeba.goomer.app
oliviasaladascentro.goomer.app
akan-culinaria-funcional.goomer.app
amandisa-cookies.goomer.app
delicias-sushi.goomer.app
gih-souza-encomendas.goomer.app
gresgastronomia.goomer.app
hardburger.goomer.app
peixe-ao-cubo-perdizes.goomer.app
1feiradigital.goomer.app
dm-help-bebidas.goomer.app
pontalzonasul.goomer.app
vila-tarego.goomer.app
biommadelivery.goomer.app
confeitaria-dama.goomer.app
customer-resource.goomer.app
jessyka-lais-confeitaria-afetiva.goomer.app
madame-formiga-4.goomer.app
senhora-adega.goomer.app
11-99424-0644.goomer.app
5150burgers.goomer.app
babaloo-gourmet.goomer.app
burger-night-sh.goomer.app
gts-distribuidora-de-produtos-alimenticios-ltda.goomer.app
norte-veg.goomer.app
packed-chef.goomer.app
tentaciones-da-venezuela-servicos-de-gastronomia-tipica.goomer.app
xama-na-pizza.goomer.app
centerville-utilidades.goomer.app
clover-pub.goomer.app
painelb.goomer.app
paoetalho.goomer.app
papai-halim.goomer.app
senhorfrederico-sm.goomer.app
2mbronzego.goomer.app
acai-da-bahia-jequie.goomer.app
acai-do-rafael.goomer.app
dom-brejas.goomer.app
149.goomer.app
acaipodirp.goomer.app
auth-resource.goomer.app
coliseu-restaurante-pizzaria-e-bar.goomer.app
ideia-saudavel.goomer.app
o-pedaco-bolos-caseiros.goomer.app
smokehouseitapema.goomer.app
corte-nobre-bc.goomer.app
goto-hortifruti-1.goomer.app
imperador-do-camarao.goomer.app
lebesguedo.goomer.app
acaidelicaruaru.goomer.app
dengo-de-caixa.goomer.app
tomodachi-sushi-bar-1.goomer.app
3.goomer.app
a-s-costa-nutri.goomer.app
le-grand-burger.goomer.app
metzi.goomer.app
505burgers.goomer.app
alfazema.goomer.app
almacen-pepe-2.goomer.app
arq-burguer.goomer.app
chillis-hot-dog-campinas.goomer.app
maryas-confeitaria-artesanal.goomer.app
meu-cannoli.goomer.app
brownies-da-rose.goomer.app
corte-nobre-1.goomer.app
doces-celina.goomer.app
painellb.goomer.app
posresource.goomer.app
madamecake.goomer.app
aldeias-hamburgueria.goomer.app
boteco-restaurante.goomer.app
brownieteriasobresuamesa.goomer.app
gato-fu.goomer.app
lojaodascarnes.goomer.app
orders-resource.goomer.app
tanakuka-box.goomer.app
acaibellanina.goomer.app
croco-gastrobar.goomer.app
worst-burguer.goomer.app
gastronomia-unisc.goomer.app
chico-barrigudo.goomer.app
gerador-de-artes-data2.dashboard.goomer.app
painelc.goomer.app
restaurante-martin-fierro.goomer.app
viva-o-doce.goomer.app
abacazo-juvev.goomer.app
brazilian-american-burgers.goomer.app
guaco-encomendas-sao-jose-dos-campos.goomer.app
mag-market.goomer.app
coletivabemleve.goomer.app
sara-confeitaria.goomer.app
siara-gastronomia.goomer.app
cora-patisserie.goomer.app
dasmeninas-marmitaria.goomer.app
restaurante-animus.goomer.app
a-quituteira.goomer.app
abaraje.goomer.app
aquela-parme-asa-norte.goomer.app
aquelaparme.goomer.app
petcenterpinheiro.goomer.app
praia-pizza-artesanal.goomer.app
3-brasseurs.goomer.app
acaiexpress.goomer.app
haya-falafel.goomer.app
mocoto-bar-e-restaurante.goomer.app
petcentersobral.goomer.app
18.goomer.app
aaiteria-jampa-1.goomer.app
box-mineiro-asa-norte.goomer.app
briellacakes.goomer.app
donamaria.goomer.app
maletortas.goomer.app
villa-frutos-do-mar.goomer.app
clavie.goomer.app
mag-market-1.goomer.app
paineld.goomer.app
sandubra.goomer.app
dudonuts.goomer.app
jaber-moema.goomer.app
japa-sette-e-pizza-sette.goomer.app
mestre-kami.goomer.app
anezia-dutra-docaria.goomer.app
big-churrasco.goomer.app
delicia-lanches-2.goomer.app
docs-partner-api.goomer.app
productsync.goomer.app
sakurakaiten-iguatemi.goomer.app
emporio-nutrisfera.goomer.app
labareda-drinks-bbq.goomer.app
restauranteparadisoencomendas.goomer.app
trust-festival-cultural-gastronomico-1.goomer.app
west-chicken.goomer.app
elefante-rosa.goomer.app
freakveganfood.goomer.app
mimos-do-libano.goomer.app
avena-lanches.goomer.app
dasmeninas-cozinhaartesanal.goomer.app
funiki-sushi-rooftop.goomer.app
pargusbrava.goomer.app
quinteiros.goomer.app
statsdashboard.goomer.app
aa-beach-cavaleiros.goomer.app
la-do-interior.goomer.app
painela.goomer.app
pirata-bar.goomer.app
queijos-da-terra.goomer.app
bagda-cozinha-arabe.goomer.app
brazas-lagoa-santa.goomer.app
dashboard-abrahao.goomer.app
statsapi.goomer.app
abaetetabacaria.goomer.app
go-salad.goomer.app
haiyo.goomer.app
mood-wine-comercio-de-vinhos.goomer.app
oliviabotafogo.goomer.app
abuh-esfihas-piracicaba.goomer.app
amore-milho-aguas-claras.goomer.app
churrasquetolareira.goomer.app
dengo-cafes.goomer.app
brigadeiro-delicia.goomer.app
buddhahouse.goomer.app
bulldogs2021.goomer.app
du-para.goomer.app
foods-lanches.goomer.app
senhorfrederico-ijui.goomer.app
sylvias-cake.goomer.app
true-food-brasil.goomer.app
acaio.goomer.app
baitacostela.goomer.app
cidade-alta-poa.goomer.app
guaco-itaim-bibi.goomer.app
kanpaibh.goomer.app
dashboard.goomer.app
restaurante.goomer.app
sushi-food-rioclaro.goomer.app
urban-farm.goomer.app
acai-da-bahia-itabuna.goomer.app
boteco-confraria.goomer.app
hidden-to-go.goomer.app
painel.goomer.app
wot-whats-on-tap.goomer.app
abaraje-descontao.goomer.app
cravoecanelabolosedoces.goomer.app
frangourmet.goomer.app
gatoveg.goomer.app
acai-do-abidu.goomer.app
cardapiodigitaldorei.goomer.app
fast-burger-delivery-1.goomer.app
o-pao-2.goomer.app
casa-mia.goomer.app
haru-fish-boutique.goomer.app
jeito-leve.goomer.app
lebistrot.goomer.app
759mesa.goomer.app
angekold.goomer.app
azedinho-doce.goomer.app
mimosquiches-sabor-e-qualidade.goomer.app
natureca.goomer.app
ouropretana-loja-da-fabrica.goomer.app
santa-batata-2.goomer.app
```

### Telefones captados

O site não ajuda a encontrar o telefone de contato.

### Características do software

Todos são iguais

- Focado **exclusivamente** em mobile
  - Ao utilizar em modo desktop, segue ocupando apenas o centro da tela
    - Isso não afeta muito negativamente a experiencia de usuário mas poderia ser melhor
- No topo há o logo da goomer
- A logo do restaurante aparece em um pequeno quadrado à esquerda
- O título aparece ao lado e logo a baixo caracteírsticas como "comida saudável" e horário de funcionamento.
- A baixo um link para ver o tempo e taxa de entrega
  - Ao clicar uma tela para adicionar endereço é aberta
    - Ao adicionar um CEP, as informações adicionais são pedidas
      - Ao fechar a tela, a taxa de entrega aproximada é apresentada no lugar onde estava o link
- Um select apresenta as sessões do cardápio
  - Ao selecionar, um smooth scroll leva até a seção do cardápio
- As seções contém um título e seus items
- Os items contem um título, uma descrição seguida de "Ver mais", o preço e uma foto ao lado direito
  - Ao clicar em "Ver mais", o item é expandido até apresentar a descrição inteira e um link "Ver menos" é apresentado.
  - Ao clicar no item, o item passa a ocupar toda a tela
    - A foto expandida é apresentada no topo do item seguido do título, descrição e preço
    - Uma caixa de Observações é apresentada à baixo com um limite de 180 caracteres
    - No rodapé um contador iniciado com 1 seguido do preço multiplicado pelo contado além de um botão adicionar
      - Ao clicar em "Adicionar", voltamos ao cardápio com um novo rodapé a baixo contendo um carrinho, "Revisar pedido" e o valor total da compra
        - Ao clicar em revisar pedido, é listado os items adicionados, um botão "Adicionar mais items" o subtotal, a taxa de entrega e o total com a taxa
        - Um campo para inserir cupom é apresentado
        - É possível selecionar uma opção de entrega que é só entrega neste caso mas acredito que também poderia ser "Retirada na loja"
      - Um botão de entrar ou cadastrar opcional é apresentado para evitar os campos a baixo
      - Os campos de nome e numero de celular são apresentados a baixo
      - As formas de pagamento podem ser adicionadas: Dinheiro, crédito, débito ou voucher
        - A princípio é apenas apresentado como "Pagar na entrega"
      - A baixo é solicitado CPF/CNPJ 
      - Um alerta de que ao enviar seu pedido você concorda com os termos de serviço e politica de uso de dados
      - Ao final o total é novamente apresentado e há um botão de fazer pedido
- na parte inferior do site é apresentado um rodapé com "Cardápio", "Busca" e "Entrar"
  - Ao clicar em "Cardápio", voltamos ao inicio do cardápio
  - Ao clicar em Busca
    - A tela é ocupada com uma barra de busca seguida das categorias do cardápio para rápido acesso
      - Ao clicar na categoria, os items da seção do cardápio são apresentadas nos resultados da busca
      - Ao digitar na barra de busca, para cada letra é apresentado os resultados em tempo real

### Planos de contrato
