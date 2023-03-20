<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com-->
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <!--<title> Login and Registration Form in HTML & CSS | CodingLab </title>-->
    <link rel="stylesheet" href="css/nuovoLogin.css">
    <!-- Fontawesome CDN Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
   </head>
<body>
  <div class="container">
    <input type="checkbox" id="flip">
    <div class="cover">
      <div class="front">
        <img src="img/tutor.jpg" alt="tutor" class="center">
        <div class="text">
          <span class="text-1">Il Tutor</span>
          <span class="text-2">Autostrade per l'Italia è da sempre impegnata nel perseguire lo sviluppo tecnologico e il miglioramento degli standard di sicurezza.</span>
        </div>
      </div>
      <div class="back">
        <!--<img class="backImg" src="images/backImg.jpg" alt="">-->
        <div class="text">
          <span class="text-1">Complete miles of journey <br> with one step</span>
          <span class="text-2">Let's get started</span>
        </div>
      </div>
    </div>
    <div class="forms">
        <div class="form-content">
          <div class="login-form">
            <div class="title">
            <%if(request.getAttribute("errMessage")!=null)
            { %> <%= request.getAttribute("errMessage")%> <%}
             else{%>Login<%}%>
             </div>
          <form action="LoginServlet" method="POST">
            <div class="input-boxes">
              <div class="input-box">
                <i class="fas fa-envelope"></i>
                <input type="text" placeholder="Inserisci la tua email" required name="email" id="email">
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Inserisci la tua password" required name="password" id="password">
              </div>
              <div class="text"><a href="#">Hai dimenticato la tua password?</a></div>
              <div class="button input-box">
                <input type="submit" value="Accedi">
              </div>
              <div class="text sign-up-text">Non hai un account? <label for="flip">Registrati ora</label></div>
            </div>
        </form>
      </div>
        <div class="signup-form">
          <div class="title">Registrazione</div>
        <form action="RegisterServlet" method="POST">
            <div class="input-boxes">
              <div class="input-box">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Inserisci il tuo nome" required name="firstname" id="firstname" class="firstname">
              </div>
              <div class="input-box">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Inscerisci il tuo cognome" required name="lastname" id="lastname" class="lastname">
              </div>
              <div class="input-box">
                <i class="fas fa-user"></i>
                <input type="text" placeholder="Inserisci il tuo CF" required name="cf" id="cf" class="cf">
              </div>
              <div class="input-box">
                <i class="fas fa-envelope"></i>
                <input type="text" placeholder="Inserisci la tua email" required name="email" id="email" class="email">
              </div>
              <div class="input-box">
                <i class="fas fa-lock"></i>
                <input type="password" placeholder="Inserisci la tua password" required name="password" id="password" class="password">
              </div>
              <div class="button input-box">
                <input type="submit" value="Invia">
              </div>
              <div class="text sign-up-text">Hai già un account? <label for="flip">Accedi ora</label></div>
            </div>
      </form>
    </div>
    </div>
    </div>
  </div>
</body>
</html>
