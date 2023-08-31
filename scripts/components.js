export const Navbar = () => {
  return `
  <nav class="navbar navbar-dark navbar-expand-lg" id="navbar">
      <div class="container">
        <a class="navbar-brand" id="logo-mobile" href="../home/index.html">
          <img src="../../assets/plane.png" alt="Daviagens logo" width="30" height="30">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasTop"
          aria-controls="offcanvasTop">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-top" tabindex="-1" id="offcanvasTop" aria-labelledby="offcanvasTopLabel">
          <div class="container">
            <div class="offcanvas-header">
              <a class="navbar-brand" id="logo-mobile" href="../home/index.html">
                <img src="../../assets/plane.png" alt="Daviagens logo" width="30" height="30">
              </a>
              <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <ul class="navbar-nav text-uppercase mx-auto mb-2 mb-lg-0">
              <li class="nav-item  fs-4">
                <a class="nav-link" aria-current="page" href="../../pages/home/index.html">Home</a>
              </li>
              <li class="nav-item fs-4">
                <a class="nav-link" href="../destinos/destinos.html">Destinos</a>
              </li>
              <a class="navbar-brand mx-3" id="logo-desktop" href="../home/index.html">
                <img src="../../assets/plane.png" alt="Daviagens logo" width="30" height="30">
              </a>
              <li class="nav-item fs-4">
                <a class="nav-link" href="../promocoes/promocoes.html">Promoções</a>
              </li>
              <li class="nav-item fs-4">
                <a class="nav-link" href="../contato/contato.html">Contato</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
  `
}

export const DestinationCard = ({ img, nome, descricaoMaior }) => {
  return `
        <div class="card" style="width: 18rem;">
          <img src="../../assets/imgs/min/${img}_min.jpg" class="card-img-top" alt="Imagem de ${nome}">
          <div class="card-body">
            <h5 class="card-title">${nome}</h5>
            <p class="card-text">${descricaoMaior}
            </p>
          </div>
        </div>
`
}

export const PromotionCard = ({ img, nome, valor, desconto }) => {
  const valorComDesconto = valor - (valor * (desconto / 100))
  return `
        <div class="card" style="width: 18rem;">
          <img src="../../assets/imgs/min/${img}_min.jpg" class="card-img-top" alt="Imagem de ${nome}">
          <div class="card-body">
            <h5 class="card-title">${nome}</h5>
          </div>
          <ul class="list-group list-group-flush position-relative bg-bg-danger  ">
          <li class="list-group-item">
          <p class="my-2 mb-1 text-secondary " style="font-size: 14px;">Preço por pessoa</p>
          <p class="mb-0 text-decoration-line-through text-secondary " style="font-size: 15px;">R$ ${valor.toFixed(2)}</p>
          <p class="mb-0" style="font-size: 25px; color: black !important;">R$ ${valorComDesconto.toFixed(2)}</p>
          <span class="position-absolute top-0 translate-middle badge rounded-pill bg-success" style="left: 35px; color: white !important;">
        ${desconto}% Off
        <span class="visually-hidden">unread messages</span>
          </li>
          </ul>
          <div class="card-body d-flex align-items-center justify-content-between">
            <a href="#" class="btn btn-primary">Comprar</a>
            <a href="#" class="btn btn-primary">Saiba mais</a>
          </div>
        </div>
  `
}

export const Footer = () => {
  return `
    <div class="container d-flex align-items-center justify-content-center h-100 text-center ">
      <p>&copy; 2023 - Criado por <br><a class="link-footer" href="https://github.com/RabbitDeWitt" target="_blank">David
          Coelho</a>
      </p>
    </div>
  `
}