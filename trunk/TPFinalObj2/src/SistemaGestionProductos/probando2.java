package SistemaGestionProductos;

public class probando2{}
	
	
	/*    
		Negocio coto = new Negocio("COTO");
		coto.generarNuevaSucursal(0);
		coto.generarNuevaSucursal(1);
		Ubicacion lacteos = new Ubicacion("L", "Lacteos");
		Ubicacion bebidas = new Ubicacion("B", "Bebidas");
		Ubicacion perfumeria = new Ubicacion("P", "Permufermia");
		Producto cocaCola = new Producto("Bebida sin Alcohol saber cola", "Coca-Cola", "BEBIDA", "ml", "Coca Cola Company");
		Producto pepsi = new Producto("Bebida sin Alcohol saber cola", "Pepsi-Cola", "BEBIDA", "ml", "PEPSICO");
		Producto fernet = new Producto("Bebida con alcohol", "Fernet", "BEBIDA ALCOHOLICA", "ml", "Branca");
		Producto leche = new Producto("Leche Entera", "Leche", "Lacteo", "ml", "La Serenisima");
		Producto manteca = new Producto("Pan de Manteca", "Manteca", "Lacteo", "gr", "SANCOR");
		Producto yogurt = new Producto("Yogurt", "Yogurt", "Lacteo", "gr", "La Serenisima");
		Producto desodorante = new Producto("Desodorante Anitranspirante", "Desodorante", "Perfumeria", "ml", "Rexona"); 
		Producto shampoo = new Producto("Shampoo para cabello", "Shampoo", "Perfumeria", "ml", "Pantene"); 
		
		Presentacion cocade600 = new Presentacion("0001", 1000, 800, 10.0, 5.0, cocaCola, 600);
		Presentacion cocade2 = new Presentacion("0002", 500, 400, 15.0, 10.0, cocaCola, 2250);
		Presentacion cocade3 = new Presentacion("0003", 500, 450, 17.0, 12.0, cocaCola, 3000);
		Presentacion pepside330 = new Presentacion("0004", 1000, 800, 5.0, 2.0, pepsi, 330);
		Presentacion pepsie2 = new Presentacion("0005", 500, 400, 15.0, 10.0, pepsi, 2250);
		Presentacion peside1yMedio = new Presentacion("0006", 500, 450, 12.0, 9.0, pepsi, 1500);
		Presentacion fernet500 = new Presentacion("0007", 100, 80, 50.0, 35.0, fernet, 500);
		Presentacion fernet750 = new Presentacion("0008", 1000, 900, 70.0, 50.0, fernet, 750);
		Presentacion fernetLitro = new Presentacion("0009", 800, 700, 80.0, 60.0, fernet, 975);
		Presentacion lecheCarton = new Presentacion("0010", 1000, 800, 10.0, 8.0, leche, 1000);
		Presentacion lecheSache = new Presentacion("0011", 1000, 850, 15.0, 10.0, leche, 1000);
		Presentacion manteca200 = new Presentacion("0012", 200, 190, 10.0, 8.0, manteca, 200);
		Presentacion manteca500 = new Presentacion("0013", 300, 280, 15.0, 10.0, manteca, 500);
		Presentacion cremix = new Presentacion("0014", 200, 190, 5.0, 3.0, yogurt, 120);
		Presentacion yogurisimo = new Presentacion("0015", 300, 280, 7.0, 5.0, yogurt, 200);
		Presentacion rexonaManGrande = new Presentacion("0016", 200, 190, 5.0, 3.0, desodorante, 200);
		Presentacion rexonaManChico = new Presentacion("0017", 300, 280, 7.0, 5.0, desodorante, 150);
		Presentacion shampoChico = new Presentacion("0018", 700, 680, 15.0, 9.0, shampoo, 165);
		Presentacion shampoProV = new Presentacion("0019", 600, 400, 17.0,10.0, shampoo, 190);
		
		lacteos.agregarProducto(leche);
		lacteos.agregarProducto(manteca);
		lacteos.agregarProducto(yogurt);
		bebidas.agregarProducto(pepsi);
		bebidas.agregarProducto(fernet);
		bebidas.agregarProducto(cocaCola);
		perfumeria.agregarProducto(shampoo);
		perfumeria.agregarProducto(desodorante);
		
		
		Cliente pablo = new Cliente("Pablo", 30000500, "12 de Octubre");
		Cliente juampi = new Cliente("Juan Pablo", 30123100, "Av. Calchaqui");
		Cliente Charly = new Cliente("Charly", 28000123, "Amoedo");
		Cliente pepe = new Cliente("Pepe Luis", 1203110, "Lamadrid");
		coto.agregarCliente(pepe);coto.agregarCliente(Charly);coto.agregarCliente(Charly);
		coto.agregarCliente(pablo);
		
		Pedido pedidoUno = new Pedido();
		Pedido pedidoDos = new Pedido();
		pedidoUno.agregarPresentacionAlPedido(cocade600, 2000);
		pedidoUno.agregarPresentacionAlPedido(pepside330, 1500);
		pedidoUno.agregarPresentacionAlPedido(peside1yMedio, 400);
		pedidoUno.agregarPresentacionAlPedido(fernet500, 500);
		pedidoUno.agregarPresentacionAlPedido(cocade3, 900);
		pedidoUno.agregarPresentacionAlPedido(pepsie2, 700);
		pedidoUno.agregarPresentacionAlPedido(cocade2, 700);
		pedidoUno.agregarPresentacionAlPedido(manteca200, 2400);
		pedidoUno.agregarPresentacionAlPedido(fernet750, 2400);
		pedidoUno.agregarPresentacionAlPedido(fernetLitro, 1100);
		pedidoUno.agregarPresentacionAlPedido(manteca500, 700);
		pedidoUno.agregarPresentacionAlPedido(lecheSache, 1200);
		pedidoUno.agregarPresentacionAlPedido(lecheCarton, 1400);
		pedidoUno.agregarPresentacionAlPedido(cremix, 1600);
		pedidoUno.agregarPresentacionAlPedido(yogurisimo, 1500);
		pedidoUno.agregarPresentacionAlPedido(rexonaManGrande, 300);
		pedidoUno.agregarPresentacionAlPedido(rexonaManChico, 400);
		pedidoUno.agregarPresentacionAlPedido(shampoChico, 700);
		pedidoUno.agregarPresentacionAlPedido(shampoProV, 800);
		pedidoDos.setFichas(pedidoUno.getFichas());
		coto.devolverSucural(0).agregarMercaderiaALaSucursal(pedidoUno);
		coto.devolverSucural(1).agregarMercaderiaALaSucursal(pedidoDos);
		
		Pedido pedidoCliente = new Pedido();
		pedidoCliente.agregarPresentacionAlPedido(cocade600, 1);
		pedidoCliente.agregarPresentacionAlPedido(rexonaManChico, 2);
		pedidoCliente.agregarPresentacionAlPedido(shampoChico, 1);
		pedidoCliente.agregarPresentacionAlPedido(fernet500, 1);
		
		coto.devolverSucural(0).efectuarVentaComun(pedidoCliente, pablo);
		System.out.println(coto.devolverSucural(0).getCaja());
	
	
	
*/