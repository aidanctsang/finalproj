const createFooter = () => {
  let footer = document.querySelector("footer");

  footer.innerHTML = `
<div class="footer-content">
    <img src="/img/logo.png" class="logo" alt="">
    <p class="footer-title">Made By Aidan Tsang, Christian Untalan, and Ryan Lim</p>
</div>
      `;
};

createFooter();
