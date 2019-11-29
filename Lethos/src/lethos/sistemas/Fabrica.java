/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lethos.sistemas;

import ifts16.pp.juego.sistemas.RepositorioPrincipal;
import lethos.entidades.Equipamiento;
import lethos.entidades.Item;
import lethos.entidades.Jugador;
import lethos.componentes.Menu;
import lethos.entidades.Personaje;
import static lethos.sistemas.Equipar.equiparItem;

/**
 *
 * @author Gabriel Maceira
 */
public class Fabrica extends FabricaPrincipalLethos {

    public static void crearLugares() {
        BaseLethos inicio = new BaseLethos("Encrucijada heroica",
                "",
                "Aquí comienza la aventura, con la primer elección.\n"
                        + "¿Oeste, al Bosque Oculto, o Este, al Desierto de los Condenados? \n", true);

        BaseLethos bosque = new BaseLethos("Bosque Oculto",
                "Los héroes avanzan sin descanso, combatiendo enemigos y naturaleza por igual.\n"
                + "En la parte más oscura se ven frente a frente con Erognar, el Anciano.\n",
                "Erognar acepta la derrota y permite el paso.\n" +
                        "Aún así sigue de pie, invitándolos a volver a enfrentarlo.\n", false);

        BaseLethos desierto = new BaseLethos("Desierto de los Condenados",
                "El sol golpea duramente a los héroes. La falta de agua los hace ver visiones.\n"
                + "¿Es una sombra aquello que ven, un resguardo ante este inhóspito clima? \n",
                "En el sitio donde La Aparición fue derrotada fuerzas de la oscuridad se concentran.\n"
                + "La Sombra de Aparición se yergue amenazante. \n", false);

        BaseLethos ipgra = new BaseLethos("Ciudad de Ipgra", "",
                "Días de camino han llevado a los tres valientes a la Ciudad de Ipgra.\n"
                + "La belleza que alguna vez adornaba sus calles,\n ahora era "
                + "reemplazada por soledad, escombros, y casas abandonadas.\n Algunos "
                + "mercados aún siguen en pie, con la esperanza de ayudar a sus "
                + "posibles salvadores \n", true);

        BaseLethos fenix = new BaseLethos("Monte Fenix",
                "Atrás queda la Ciudad de Ipgra, lejana. Lo empinado del Monte Fenix complica la subida.\n"
                + "De pronto, el paso de los guerreros es frenado por un Troll. \n",
                "Herido pero no muerto, el Troll había dado aviso a sus colegas.\nOtro Troll, todavía"
                + "más imponente que el anterior, merodea la zona. \n", false);

        BaseLethos cueva = new BaseLethos("Cueva de Lava",
                "Al Norte de la Ciudad de Ipgra se halla la Cueva de Lava, con sus muchos túneles y peligros. \n"
                + "Murciélagos y pequeñas criaturas habitan su interior. \n¿QUIÉN OSA ENTRAR EN MIS DOMINIOS "
                + "SIN PERMISO? retumbó en techos y paredes \n",
                "Del corazón de la cueva, de entre el magma, se siente una presencia burbujear vida. \n", false);

        BaseLethos palacio = new BaseLethos("Palacio de Cristal",
                "Hacia el este de la Ciudad de Ipgra el viento comienza a volverse helado. \n"
                        + "La temperatura desciende más y más, casi al punto de congelamiento \na la par que los héroes se acercan a la estructura de Cristal, atraidos por lamentos. \n"
                + "El interior del Palacio está vacío, sólo armaduras viejas y el lamento llenan sus pasillos.\n"
                        + "'NUNCA FALLA. NUEVAS VÍCTIMAS.' \n",
                "Del interior del Palacio se oyen nuevos lamentos, más oscuros, \n"
                        + "pareciendose más a una risa insana. \n", false);
        
        BaseLethos volcan = new BaseLethos("Volcán de Ipgra",
                "",
                "El aire se llena de una magia revigorizante en el núcleo del Volcán.\n"
                        + "'Bienvenidos, mortales. Soy la Diosa Ipgra. \n Por favor acepten este don "
                        + "para ayudarles en su aventura.' \n", true);

        BaseLethos paramo = new BaseLethos("Páramo Helado",
                "",
                "En las laderas circundando el Palacio de Cristal varias runas y sellos protegen tesoros. \n"
                        + "Usando técnicas y cantos milenarios, el mago logra remover todas las trabas. \n", true);

        BaseLethos babel = new BaseLethos("Torre de Babel",
                "Cientos de escalones separan a los valientes de su objetivo. Sin perder el tiempo se echan hacia su futuro.\n"
                        + "A medida que ascienden la luz empieza a desaparecer, y ruido de truenos y alas se hacen más presentes. \n"
                        + "'¿Qué es eso?' de entre las nubes emerge la Serpiente Emplumada. \n",
                "Como por arte de magia, en lo alto de la Torre de Babel, nubes y rayos se conglomeran \n"
                        + "lentamente dando forma física a una nueva Serpiente Emplumada.\n"
                        + "'Lo mejor será apurar el paso.'\n", false);

        BaseLethos nothingness = new BaseLethos("La Nada",
                "Pasando la Torre de Babel esta La Nada, cuyo único habitante es Kobo el Príncipe Goblin. \n"
                        + "'Bienvenidos al fin de sus días, perdedores.' \n",
                "'NOOOOOOOOooooooooooooooo!' se oyó durante un momento antes de que Kobo fuese devorado por la Nada.\n"
                        + "Los Héroes se unen sus armas y por fuerza de Ipgra vuelven al mundo, victoriosos.", false);

        inicio.agregarVecino(bosque.referencia("Bosque Oculto"));
        inicio.agregarVecino(desierto.referencia("Desierto de los Condenados"));
        bosque.agregarVecino(inicio.referencia("Encrucijada heroica"));
        bosque.agregarVecino(ipgra.referencia("Ciudad de Ipgra"));
        desierto.agregarVecino(inicio.referencia("Encrucijada heroica"));
        desierto.agregarVecino(ipgra.referencia("Ciudad de Ipgra"));
        ipgra.agregarVecino(bosque.referencia("Bosque Oculto"));
        ipgra.agregarVecino(desierto.referencia("Desierto de los Condenados"));
        ipgra.agregarVecino(fenix.referencia("Monte Fenix"));
        ipgra.agregarVecino(cueva.referencia("Cueva de Lava"));
        ipgra.agregarVecino(palacio.referencia("Palacio de Cristal"));
        fenix.agregarVecino(ipgra.referencia("Ciudad de Ipgra"));
        fenix.agregarVecino(volcan.referencia("Volcan de Ipgra"));
        cueva.agregarVecino(ipgra.referencia("Ciudad de Ipgra"));
        cueva.agregarVecino(volcan.referencia("Volcan de Ipgra"));
        palacio.agregarVecino(ipgra.referencia("Ciudad de Ipgra"));
        palacio.agregarVecino(paramo.referencia("Paramo Helado"));
        volcan.agregarVecino(fenix.referencia("Monte Fenix"));
        volcan.agregarVecino(cueva.referencia("Cueva de Lava"));
        volcan.agregarVecino(babel.referencia("Torre de Babel"));
        paramo.agregarVecino(palacio.referencia("Palacio de Cristal"));
        paramo.agregarVecino(babel.referencia("Torre de Babel"));
        babel.agregarVecino(volcan.referencia("Volcan de Ipgra"));
        babel.agregarVecino(paramo.referencia("Paramo Helado"));
        babel.agregarVecino(nothingness.referencia("La Nada"));
        
        RepositorioPrincipal.agregar(inicio, "inicio");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(bosque, "bosque");
        Fabrica.agregarIdLugar(bosque.getId());
        RepositorioPrincipal.agregar(desierto, "desierto");
        Fabrica.agregarIdLugar(desierto.getId());
        RepositorioPrincipal.agregar(ipgra, "ipgra");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(fenix, "fenix");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(cueva, "cueva");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(palacio, "palacio");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(volcan, "volcan");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(paramo, "paramo");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(babel, "babel");
        Fabrica.agregarIdLugar(inicio.getId());
        RepositorioPrincipal.agregar(nothingness, "nothingness");
        Fabrica.agregarIdLugar(inicio.getId());
        
    }
    
    public static void crearItems() {
        Item elixir = new Item("Elixir", "Recupera 60% del HP máximo", 10);
        RepositorioPrincipal.agregar(elixir,"Elixir");
        Fabrica.agregarIdItem(elixir.getId());
        
        Item besoDelAlba = new Item("Beso Del Alba", "Recupera 25% del HP máximo a todos los aliados inconscientes, y los despierta.", 5);
        RepositorioPrincipal.agregar(besoDelAlba,"Beso Del Alba");
        Fabrica.agregarIdItem(besoDelAlba.getId());
        
        Item bendicionFuego = new Item("Bendición de Fuego", "Aumenta en 1 el Nivel de la Magia de Fuego.", 0);
        RepositorioPrincipal.agregar(bendicionFuego,"bendicionFuego");
        bendicionFuego.desactivar();
        
        Item bendicionHielo = new Item("Bendición de Hielo", "Aumenta en 1 el Nivel de la Magia de Hielo.", 0);
        RepositorioPrincipal.agregar(bendicionHielo,"bendicionHielo");
        bendicionHielo.desactivar();
        
        Item bendicionVida = new Item("Bendición de Vida", "Aumenta en 1 el Nivel de la Magia de Vida.", 0);
        RepositorioPrincipal.agregar(bendicionVida,"bendicionVida");
        bendicionVida.desactivar();
        
        Item vuelo = new Item("Vuelo", "Permite viajar instantáneamente a la Ciudad de Ipgra.", 0);
        RepositorioPrincipal.agregar(vuelo,"Vuelo");
        bendicionVida.desactivar();
        
    }
    
    public static void asignarItemLugar() {
        BaseLethos lugar = (BaseLethos) RepositorioPrincipal.traer("fenix");
        Item item = (Item) RepositorioPrincipal.traer("bendicionVida");
        lugar.agregarItem(item.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("paramo");
        item = (Item) RepositorioPrincipal.traer("bendicionHielo");
        lugar.agregarItem(item.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("volcan");
        item = (Item) RepositorioPrincipal.traer("bendicionFuego");
        lugar.agregarItem(item.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("ipgra");
        item = (Item) RepositorioPrincipal.traer("Vuelo");
        lugar.agregarItem(item.referencia());
    }
    
    public static void crearPersonajes() {
        crearCaballero();
        crearMago();
        crearArquero();
    }
    
    public static void crearCaballero() {
        Personaje caballero = new Personaje("Caballero");
        caballero.setMaxHP(200);
        caballero.setCurrentHP(200);
        caballero.setAtaque(60);
        caballero.setDefensa(40);
        caballero.setVelocidad(40);
        caballero.setCantidadAtaques(1);
        caballero.setMagia(0);
        caballero.setDefensaMagica(10);
        caballero.setAccuracy(90);
        caballero.setActivo(true);
        caballero.setEnvenenado(false);
        RepositorioPrincipal.agregar(caballero, "Caballero");
        Fabrica.agregarIdPersonaje(caballero.getId());
    }
    
    public static void crearMago() {
        Personaje mago = new Personaje("Mago");
        mago.setMaxHP(100);
        mago.setCurrentHP(100);
        mago.setAtaque(0);
        mago.setDefensa(10);
        mago.setVelocidad(70);
        mago.setCantidadAtaques(0);
        mago.setMagia(50);
        mago.setDefensaMagica(55);
        mago.setAccuracy(0);
        mago.setActivo(true);
        mago.setEnvenenado(false);
        RepositorioPrincipal.agregar(mago, "Mago");
        Fabrica.agregarIdPersonaje(mago.getId());
    }
    
    public static void crearArquero() {
        Personaje arquero = new Personaje("Arquero");
        arquero.setMaxHP(135);
        arquero.setCurrentHP(135);
        arquero.setAtaque(20);
        arquero.setDefensa(30);
        arquero.setVelocidad(110);
        arquero.setCantidadAtaques(1);
        arquero.setMagia(20);
        arquero.setDefensaMagica(25);
        arquero.setAccuracy(225);
        arquero.setActivo(true);
        arquero.setEnvenenado(false);
        RepositorioPrincipal.agregar(arquero, "Arquero");
        Fabrica.agregarIdPersonaje(arquero.getId());
    }
    
    public static void crearEnemigos() {
        crearErognar();
        crearAparicion();
        crearTroll();
        crearMagma();
        crearSerena();
        crearSerpiente();
        crearKobo();
    }
        
    public static void crearErognar() {
        Personaje erognar = new Personaje("Erognar, el Anciano");
        erognar.setMaxHP(600);
        erognar.setCurrentHP(600);
        erognar.setAtaque(20);
        erognar.setDefensa(20);
        erognar.setVelocidad(30);
        erognar.setCantidadAtaques(1);
        erognar.setMagia(35);
        erognar.setDefensaMagica(10);
        erognar.setAccuracy(50);
        erognar.setActivo(true);
        erognar.setEnvenenado(false);
        RepositorioPrincipal.agregar(erognar, "erognar");
    } 

    public static void crearAparicion() {
        Personaje aparicion = new Personaje("Aparición");
        aparicion.setMaxHP(1200);
        aparicion.setCurrentHP(1200);
        aparicion.setAtaque(30);
        aparicion.setDefensa(30);
        aparicion.setVelocidad(50);
        aparicion.setCantidadAtaques(1);
        aparicion.setMagia(50);
        aparicion.setDefensaMagica(20);
        aparicion.setAccuracy(130);
        aparicion.setActivo(true);
        aparicion.setEnvenenado(false);
        RepositorioPrincipal.agregar(aparicion, "aparicion");
    }
    
    public static void crearTroll() {
        Personaje troll = new Personaje("Troll de la Montaña");
        troll.setMaxHP(1800);
        troll.setCurrentHP(1800);
        troll.setAtaque(130);
        troll.setDefensa(100);
        troll.setVelocidad(75);
        troll.setCantidadAtaques(1);
        troll.setMagia(0);
        troll.setDefensaMagica(40);
        troll.setAccuracy(110);
        troll.setActivo(true);
        troll.setEnvenenado(false);
        RepositorioPrincipal.agregar(troll, "troll");
    }
    
    public static void crearMagma() {
        Personaje magma = new Personaje("Gigante de Magma");
        magma.setMaxHP(2500);
        magma.setCurrentHP(2500);
        magma.setAtaque(190);
        magma.setDefensa(150);
        magma.setVelocidad(125);
        magma.setCantidadAtaques(1);
        magma.setMagia(140);
        magma.setDefensaMagica(100);
        magma.setAccuracy(100);
        magma.setActivo(true);
        magma.setEnvenenado(false);
        RepositorioPrincipal.agregar(magma, "magma");
    }
    
    public static void crearSerena() {
        Personaje serena = new Personaje("Serena, Sacerdotisa de Diamante");
        serena.setMaxHP(4000);
        serena.setCurrentHP(4000);
        serena.setAtaque(130);
        serena.setDefensa(180);
        serena.setVelocidad(150);
        serena.setCantidadAtaques(2);
        serena.setMagia(180);
        serena.setDefensaMagica(200);
        serena.setAccuracy(180);
        serena.setActivo(true);
        serena.setEnvenenado(false);
        RepositorioPrincipal.agregar(serena, "serena");
    }
    
    public static void crearSerpiente() {
        Personaje serpiente = new Personaje("Serpiente Emplumada");
        serpiente.setMaxHP(6666);
        serpiente.setCurrentHP(6666);
        serpiente.setAtaque(230);
        serpiente.setDefensa(300);
        serpiente.setVelocidad(150);
        serpiente.setCantidadAtaques(1);
        serpiente.setMagia(200);
        serpiente.setDefensaMagica(300);
        serpiente.setAccuracy(280);
        serpiente.setActivo(true);
        serpiente.setEnvenenado(false);
        RepositorioPrincipal.agregar(serpiente, "serpiente");
    }
    
    public static void crearKobo() {
        Personaje kobo = new Personaje("Kobo, Príncipe Goblin");
        kobo.setMaxHP(9999);
        kobo.setCurrentHP(9999);
        kobo.setAtaque(290);
        kobo.setDefensa(230);
        kobo.setVelocidad(210);
        kobo.setCantidadAtaques(1);
        kobo.setMagia(190);
        kobo.setDefensaMagica(230);
        kobo.setAccuracy(210);
        kobo.setActivo(true);
        kobo.setEnvenenado(false);
        RepositorioPrincipal.agregar(kobo, "kobo");
    }
    
    public static void asignarEnemigoLugar() {
        BaseLethos lugar = (BaseLethos) RepositorioPrincipal.traer("bosque");
        Personaje enemigo = (Personaje) RepositorioPrincipal.traer("erognar");
        lugar.agregarLuchador(enemigo.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("desierto");
        enemigo = (Personaje) RepositorioPrincipal.traer("aparicion");
        lugar.agregarLuchador(enemigo.referencia());

        lugar = (BaseLethos) RepositorioPrincipal.traer("fenix");
        enemigo = (Personaje) RepositorioPrincipal.traer("troll");
        lugar.agregarLuchador(enemigo.referencia());

        lugar = (BaseLethos) RepositorioPrincipal.traer("cueva");
        enemigo = (Personaje) RepositorioPrincipal.traer("magma");
        lugar.agregarLuchador(enemigo.referencia());

        lugar = (BaseLethos) RepositorioPrincipal.traer("palacio");
        enemigo = (Personaje) RepositorioPrincipal.traer("serena");
        lugar.agregarLuchador(enemigo.referencia());

        lugar = (BaseLethos) RepositorioPrincipal.traer("babel");
        enemigo = (Personaje) RepositorioPrincipal.traer("serpiente");
        lugar.agregarLuchador(enemigo.referencia());

        lugar = (BaseLethos) RepositorioPrincipal.traer("nothingness");
        enemigo = (Personaje) RepositorioPrincipal.traer("kobo");
        lugar.agregarLuchador(enemigo.referencia());
    }
    
    public static void crearMenu() {
        Menu menu_principal = new Menu("Menu Principal");
        RepositorioPrincipal.agregar(menu_principal, "menu_principal");
        Fabrica.agregarIdMenu(menu_principal.getId());
        
        Menu menu_status = new Menu("Menu de Status");
        RepositorioPrincipal.agregar(menu_status, "menu_status");
        Fabrica.agregarIdMenu(menu_status.getId());
        
        Menu menu_items = new Menu("Menu de Items");
        RepositorioPrincipal.agregar(menu_items, "menu_items");
        Fabrica.agregarIdMenu(menu_items.getId());
        
        Menu menu_equipo = new Menu("Menu de Equipo");
        RepositorioPrincipal.agregar(menu_equipo, "menu_equipo");
        Fabrica.agregarIdMenu(menu_equipo.getId());
        
        menu_principal.agregarEntradaMenu(menu_status.referenciaMenus("Menu de Status"));
        menu_principal.agregarEntradaMenu(menu_items.referenciaMenus("Menu de Items"));
        menu_principal.agregarEntradaMenu(menu_equipo.referenciaMenus("Menu de Equipo"));
        
        menu_status.agregarEntradaMenu(menu_principal.referenciaMenus("Menu Principal"));
        menu_status.agregarEntradaMenu(menu_items.referenciaMenus("Menu de Items"));
        menu_status.agregarEntradaMenu(menu_equipo.referenciaMenus("Menu de Equipo"));
        
        menu_items.agregarEntradaMenu(menu_principal.referenciaMenus("Menu Principal"));
        menu_items.agregarEntradaMenu(menu_status.referenciaMenus("Menu de Status"));     
        menu_items.agregarEntradaMenu(menu_equipo.referenciaMenus("Menu de Equipo"));     
        
        menu_equipo.agregarEntradaMenu(menu_principal.referenciaMenus("Menu Principal"));
        menu_equipo.agregarEntradaMenu(menu_status.referenciaMenus("Menu de Status"));   
        menu_equipo.agregarEntradaMenu(menu_items.referenciaMenus("Menu de Items"));
        
        Menu menu_combate = new Menu("Menu Combate");
        RepositorioPrincipal.agregar(menu_combate, "menu_combate");
        Fabrica.agregarIdMenu(menu_combate.getId());

        Menu menu_ataque = new Menu("Atacar");
        RepositorioPrincipal.agregar(menu_ataque, "menu_ataque");
        Fabrica.agregarIdMenu(menu_ataque.getId());
        
        Menu menu_defender = new Menu("Defender");
        RepositorioPrincipal.agregar(menu_defender, "menu_defender");
        Fabrica.agregarIdMenu(menu_defender.getId());

        Menu menu_magia_blanca = new Menu("Menu Blanca");
        RepositorioPrincipal.agregar(menu_magia_blanca, "menu_magia_blanca");
        Fabrica.agregarIdMenu(menu_magia_blanca.getId());

        Menu menu_magia_negra = new Menu("Menu Negra");
        RepositorioPrincipal.agregar(menu_magia_negra, "menu_magia_negra");
        Fabrica.agregarIdMenu(menu_magia_negra.getId());
        
        Menu menu_usar_item = new Menu("Usar Item");
        RepositorioPrincipal.agregar(menu_usar_item, "menu_usar_item");
        Fabrica.agregarIdMenu(menu_usar_item.getId());

        menu_combate.agregarEntradaMenu(menu_ataque.referenciaMenus("Atacar"));
        menu_combate.agregarEntradaMenu(menu_defender.referenciaMenus("Defender")); 
        menu_combate.agregarEntradaMenu(menu_magia_blanca.referenciaMenus("Menu Blanca"));
        menu_combate.agregarEntradaMenu(menu_magia_negra.referenciaMenus("Menu Negra"));
        menu_combate.agregarEntradaMenu(menu_usar_item.referenciaMenus("Usar Item"));
        
        menu_ataque.agregarEntradaMenu(menu_combate.referenciaMenus("Menu Combate"));
        menu_defender.agregarEntradaMenu(menu_combate.referenciaMenus("Menu Combate")); 
        menu_magia_blanca.agregarEntradaMenu(menu_combate.referenciaMenus("Menu Combate"));
        menu_magia_negra.agregarEntradaMenu(menu_combate.referenciaMenus("Menu Combate"));
        menu_usar_item.agregarEntradaMenu(menu_combate.referenciaMenus("Menu Combate"));
    }
    
    public static void crearEquipamiento(Jugador player) {
        Equipamiento espadaHeroe = new Equipamiento("Espada del Héroe", "Espada inicial del Caballero", 
                "Caballero", "espada", 0, 0, 0, 0, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(espadaHeroe,"espadaHeroe");
        Fabrica.agregarIdEquipo(espadaHeroe.getId());
        player.getOpcionesEquipo().agregar(espadaHeroe.getId(), espadaHeroe.getNombre() + " - " + espadaHeroe.getDescripcion());
        
        Equipamiento espadaHierro = new Equipamiento("Espada de Hierro", "+40 de daño al Caballero", 
                "Caballero", "espada", 0, 40, 0, 0, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(espadaHierro,"espadaHierro");
        Fabrica.agregarIdEquipo(espadaHierro.getId());
        player.getOpcionesEquipo().agregar(espadaHierro.getId(), espadaHierro.getNombre() + " - " + espadaHierro.getDescripcion());
        
        Equipamiento espadaMundos = new Equipamiento("Espada Destructora de Mundos", "+120 de Ataque, +25 de Defensa, +10 Velocidad, +40 Precisión (ACC) al Caballero", 
                "Caballero", "espada", 0, 120, 25, 10, 1, 0, 0, 40);
        RepositorioPrincipal.agregar(espadaMundos,"espadaMundos");
        Fabrica.agregarIdEquipo(espadaMundos.getId());
        player.getOpcionesEquipo().agregar(espadaMundos.getId(), espadaMundos.getNombre() + " - " + espadaMundos.getDescripcion());
        
        Equipamiento escudoHeroe = new Equipamiento("Escudo del Héroe", "Escudo inicial del Caballero", 
                "Caballero", "escudo", 0, 0, 0, 0, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(escudoHeroe,"escudoHeroe");
        Fabrica.agregarIdEquipo(escudoHeroe.getId());
        player.getOpcionesEquipo().agregar(escudoHeroe.getId(), escudoHeroe.getNombre() + " - " + escudoHeroe.getDescripcion());
        
        Equipamiento escudoFenix = new Equipamiento("Escudo Fénix", "Da +100 de Defensa, +45 Defensa Mágica al Caballero.", 
                "Caballero", "escudo", 0, 0, 100, 0, 0, 0, 45, 0);
        RepositorioPrincipal.agregar(escudoFenix,"escudoFenix");
        Fabrica.agregarIdEquipo(escudoFenix.getId());
        player.getOpcionesEquipo().agregar(escudoFenix.getId(), escudoFenix.getNombre() + " - " + escudoFenix.getDescripcion());

        Equipamiento cetroMadera = new Equipamiento("Cetro de Madera", "Cetro inicial del Mago", 
                "Mago", "cetro", 0, 0, 0, 0, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(cetroMadera,"cetroMadera");
        Fabrica.agregarIdEquipo(cetroMadera.getId());
        player.getOpcionesEquipo().agregar(cetroMadera.getId(), cetroMadera.getNombre() + " - " + cetroMadera.getDescripcion());
        
        Equipamiento cetroSol = new Equipamiento("Cetro del Sol", "Da +110 de Magia, +45 Defensa Mágica, +10 Velocidad al Mago.", 
                "Mago", "cetro", 0, 0, 0, 10, 0, 110, 45, 0);
        RepositorioPrincipal.agregar(cetroSol,"cetroSol");
        Fabrica.agregarIdEquipo(cetroSol.getId());
        player.getOpcionesEquipo().agregar(cetroSol.getId(), cetroSol.getNombre() + " - " + cetroSol.getDescripcion());

        Equipamiento capaNiebla = new Equipamiento("Capa de Niebla", "Da +40 de Defensa, +20 Defensa Mágica, +20 Velocidad al Mago.", 
                "Mago", "tunica", 0, 0, 40, 20, 0, 0, 20, 0);
        RepositorioPrincipal.agregar(capaNiebla,"capaNiebla");
         Fabrica.agregarIdEquipo(capaNiebla.getId());
        player.getOpcionesEquipo().agregar(capaNiebla.getId(), capaNiebla.getNombre() + " - " + capaNiebla.getDescripcion());
         
        Equipamiento tunicaSiervo = new Equipamiento("Túnica del Siervo del Otro Mundo", "Da +60 de Defensa, +80 Defensa Mágica, +40 Velocidad al Mago.", 
                "Mago", "tunica", 0, 0, 60, 60, 0, 0, 60, 0);
        RepositorioPrincipal.agregar(tunicaSiervo,"tunicaSiervo");
        Fabrica.agregarIdEquipo(tunicaSiervo.getId());
        player.getOpcionesEquipo().agregar(tunicaSiervo.getId(), tunicaSiervo.getNombre() + " - " + tunicaSiervo.getDescripcion());
        
        Equipamiento arcoElfo = new Equipamiento("Arco elfo", "Arco inicial del Arquero.", 
                "Arquero", "arco", 0, 0, 0, 0, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(arcoElfo,"arcoElfo");
        Fabrica.agregarIdEquipo(arcoElfo.getId());
        player.getOpcionesEquipo().agregar(arcoElfo.getId(), arcoElfo.getNombre() + " - " + arcoElfo.getDescripcion());

        Equipamiento arcoKore = new Equipamiento("Arco de Kore", "Da +50 de Velocidad, +20 Precisión (ACC) al Arquero.", 
                "Arquero", "arco", 0, 0, 0, 50, 0, 0, 0, 20);
        RepositorioPrincipal.agregar(arcoKore,"arcoKore");
        Fabrica.agregarIdEquipo(arcoKore.getId());
        player.getOpcionesEquipo().agregar(arcoKore.getId(), arcoKore.getNombre() + " - " + arcoKore.getDescripcion());

        Equipamiento flechasMadera = new Equipamiento("Flechas de madera", "Flechas iniciales del Arquero.", 
                "Arquero", "flechas", 0, 0, 0, 0, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(flechasMadera,"flechasMadera");
        Fabrica.agregarIdEquipo(flechasMadera.getId());
        player.getOpcionesEquipo().agregar(flechasMadera.getId(), flechasMadera.getNombre() + " - " + flechasMadera.getDescripcion());

        Equipamiento flechasRoble = new Equipamiento("Flechas de Roble", "Da +10 de Ataque al Arquero.", 
                "Arquero", "flechas", 0, 10, 0, 0, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(flechasRoble,"flechasRoble");
        Fabrica.agregarIdEquipo(flechasRoble.getId());
        player.getOpcionesEquipo().agregar(flechasRoble.getId(), flechasRoble.getNombre() + " - " + flechasRoble.getDescripcion());

        Equipamiento flechasEncantadas = new Equipamiento("Flechas Encantadas", "Da +25 de Ataque, +15 Precisión (ACC), +1 Número de Ataques al Arquero.", 
                "Arquero", "flechas", 0, 25, 0, 0, 1, 0, 0, 15);
        RepositorioPrincipal.agregar(flechasEncantadas,"flechasEncantadas");
        Fabrica.agregarIdEquipo(flechasEncantadas.getId());
        player.getOpcionesEquipo().agregar(flechasEncantadas.getId(), flechasEncantadas.getNombre() + " - " + flechasEncantadas.getDescripcion());
        
        Equipamiento pecheraCristal = new Equipamiento("Pechera de Cristal", "Da +70 de Defensa, +70 de Defensa Mágica, +10 Velocidad al Arquero.", 
                "Arquero", "pechera", 0, 0, 70, 10, 0, 0, 70, 0);
        RepositorioPrincipal.agregar(pecheraCristal,"pecheraCristal");
        Fabrica.agregarIdEquipo(pecheraCristal.getId());
        player.getOpcionesEquipo().agregar(pecheraCristal.getId(), pecheraCristal.getNombre() + " - " + pecheraCristal.getDescripcion());
        
        Equipamiento anilloNibelungo = new Equipamiento("Anillo Nibelungo", "Da +100 de Magia al Mago.", 
                "Mago", "accesorio", 0, 0, 00, 10, 0, 100, 0, 0);
        RepositorioPrincipal.agregar(anilloNibelungo,"anilloNibelungo");
        player.getOpcionesEquipo().agregar(anilloNibelungo.getId(), anilloNibelungo.getNombre() + " - " + anilloNibelungo.getDescripcion());
        
        Equipamiento zapatosAlados = new Equipamiento("Zapatos Alados", "Da +75 de Velocidad, +15 de Defensa al Arquero.", 
                "Arquero", "accesorio", 0, 0, 15, 75, 0, 0, 0, 0);
        RepositorioPrincipal.agregar(zapatosAlados,"zapatosAlados");
        Fabrica.agregarIdEquipo(zapatosAlados.getId());
        player.getOpcionesEquipo().agregar(zapatosAlados.getId(), zapatosAlados.getNombre() + " - " + zapatosAlados.getDescripcion());

        BaseLethos lugar = (BaseLethos) RepositorioPrincipal.traer("bosque");
        lugar.agregarEquipoLugar(espadaHierro.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("bosque");
        lugar.agregarEquipoLugar(capaNiebla.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("desierto");
        lugar.agregarEquipoLugar(arcoKore.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("ipgra");
        lugar.agregarEquipoLugar(flechasRoble.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("fenix");
        lugar.agregarEquipoLugar(escudoFenix.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("fenix");
        lugar.agregarEquipoLugar(flechasEncantadas.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("fenix");
        lugar.agregarEquipoLugar(cetroSol.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("cueva");
        lugar.agregarEquipoLugar(tunicaSiervo.referencia());
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("palacio");
        lugar.agregarEquipoLugar(pecheraCristal.referencia());

        lugar = (BaseLethos) RepositorioPrincipal.traer("volcan");
        lugar.agregarEquipoLugar(zapatosAlados.referencia());

        lugar = (BaseLethos) RepositorioPrincipal.traer("babel");
        lugar.agregarEquipoLugar(anilloNibelungo.referencia()); 
        
        lugar = (BaseLethos) RepositorioPrincipal.traer("babel");
        lugar.agregarEquipoLugar(espadaMundos.referencia()); 
    }
    
    public static void equipoIncialPersonajes() {
        Personaje personaje = (Personaje) RepositorioPrincipal.traer("Caballero");
        Equipamiento equipo = (Equipamiento) RepositorioPrincipal.traer("espadaHeroe");      
        personaje.setManoDerecha(equipo.getId());
        equipo = (Equipamiento) RepositorioPrincipal.traer("escudoHeroe");
        personaje.setManoIzquierda(equipo.getId());
       
        personaje = (Personaje) RepositorioPrincipal.traer("Mago");
        equipo = (Equipamiento) RepositorioPrincipal.traer("cetroMadera");
        personaje.setManoDerecha(equipo.getId());

        personaje = (Personaje) RepositorioPrincipal.traer("Arquero");
        equipo = (Equipamiento) RepositorioPrincipal.traer("arcoElfo");
        personaje.setManoDerecha(equipo.getId());
        equipo = (Equipamiento) RepositorioPrincipal.traer("flechasMadera");
        personaje.setManoIzquierda(equipo.getId());
    }
    
}