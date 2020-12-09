import java.util.Scanner;
public class Main {
    Scanner numero= new Scanner(System.in);
    Scanner scanner= new Scanner(System.in);    
    String nameUser;
    int productoAeliminar=0,VolverAeliminar=0,optionMenuElimiar, numNIT,valNIT, TOTAL,pago,vuelto, opcionMenuCompra=0,totalDeComprasRealizadas=1,optionmenuerror=0, confirmacion=0,CancelarFalse=0,CancelarTrue=0, opcvolver=0;
    //DESAYUNOS
    String[] vecdesayuno = { "", "Paches", "Chuchitos", "Tortitas de huevo arroz", "Quesadillas de arroz","Huevo frito" };
    int[] preciodesayuno = { 0, 9, 3, 10, 9, 8 };
    int optionDesayuno;
    //ALMUERZOS 
    String[] vecalmuerzo = { "", "Pepian", "Carne asada", "Pollo dorado", "Carne adobada", "Kak ik" };
    int[] precioalmuerzo = { 0, 15, 20, 25, 25, 30 };
    int optionAlmuerzo;
    //CENAS
    String[] veccena = { "", "ensalada roja", "Omelette con champiñones y espinaca","Pechuga de pollo a la plancha", "Tacos de lechuga con lentejas","Ensalada de espinacas y pechuga de pavo" };
    int[] preciocena = { 0, 7, 10, 13, 5, 10 };
    int optionCena;
    //BEBIDAS
    String[] vecbebidas = { "", "Refresco de súchiles", "Fresco de chilacayote", "Horchata", "Fresco de chan","Ponche navideño", "Gaseosa(cocacola)", "Gaseosa(mirinda)", "Gaseosa(seven-up)", "Gaseosa(Pepsi)","refresco de Tamarindo" };
    int[] preciobebida = { 0, 5, 9, 8, 6, 9, 5, 3, 4, 3, 4 };
    int optionBebida;
    //POSTRES
    String[] vecpostre = { "", "Torta Rellena Cremosa", "Mini Panqueques con Dulce de Leche", "Pastel de Zanahoria","Crumble de Fresas", "Pastel de vainilla", "Bombones de Chocolate Blanco","Torta Doble Chocolate con Oreo", "Torta de Oreo y Chocolate", "Torta Napolitana Triple","Pastel de Fresas con Crema" };
    int[] preciopostre = { 0, 11, 9, 8, 6, 15, 4, 5, 12, 8, 14 };
    int optionPostre;
    //VARIABLES DE ALMACENAMIENTO    
    String productos[]= new String[100];
    int cantidad=0,contador=1,contador2=0;
    int Precios[]=new int[100],unidades[]=new int[100];
    //MOSTRANDO TIEMPOS DE COMIDA
    void mostrar(String comida[],int precio[], int option,int finalMenu){  
        do{ 
            opcionMenuCompra=0;
        do{
            System.out.println("\n--------------------------------------------------------------------------------------");
        for(int i = 1 ;i<=finalMenu;i++){
            System.out.println(i + "." + " " + comida[i] + "..." + "Q" + precio[i]);
        }
        if(finalMenu==5){
        System.out.println("6. Volver al menu principal");
    }
    if(finalMenu==10){
        System.out.println("11. Volver al menu principal");
    }
        System.out.print("ingrese a la opcion que desee: ");
        opcvolver   =numero.nextInt(); 
        option= opcvolver; 
        if(option<1||option>finalMenu+1){PrintError();}
                      
    }while(opcionMenuCompra==1||option<1||option>finalMenu+1); 
    if(option!=finalMenu+1){       
    ProcesoDeCompra(comida, precio, option);   
}
}while(opcionMenuCompra==1);   
    }
    //ALMACENANDO PRODUCTOS 
    void AgregarProducto(String comida[],int precio[], int option){
        for(int i = 1;i<2;i++){
            productos[contador]=comida[option];
            Precios[contador]=precio[option];
            unidades[contador]=cantidad;
            contador++;
            totalDeComprasRealizadas++;
        }
    }  
    void Total(){
        for(int i = 1;i<totalDeComprasRealizadas;i++){               
            TOTAL+= unidades[i] * Precios[i] ;
        }
    }
    //PROCESO DE COMPRA
    void ProcesoDeCompra(String comida[],int precio[], int option){
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("¿Cuantas unidades de "+comida[option]+" desea adquirir ?");
        System.out.print("ingrese: ");
        cantidad=numero.nextInt();
        AgregarProducto(comida, precio, option);
        this.contador2++;
        System.out.println(cantidad+" unidades fueron agregados");
        System.out.println("------------------------------------------------");  
        System.out.println();
        do{
        System.out.println("1. Seguir ordenando desde el menú actual");
        System.out.println("2. Volver al menú principal");
        System.out.println("3. Facturar");
        System.out.println("4. Cancelar un producto");
        System.out.println("5. Cancelar todas las compras");
        System.out.print("ingrese: ");        
        opcionMenuCompra=numero.nextInt();
        if(opcionMenuCompra>5||opcionMenuCompra<1){
            PrintError();
        } 
        if(opcionMenuCompra==3){
           PrintFactura();
        }
        if(opcionMenuCompra==4){
            do{
            System.out.println("---------MENU ELIMINAR PRODUCTO-----");
            System.out.println("productos                ");
           for(int i= 1;i<=contador2;i++){
              System.out.println(i+". "+productos[i]+"------------Unidades: "+unidades[i]);
           }
           do{
           System.out.println("ingrese el numero del producto que desea eliminar: ");
           productoAeliminar=numero.nextInt();
           if(productoAeliminar<1||productoAeliminar>contador2){PrintError();}
        }while(productoAeliminar<1||productoAeliminar>contador2);
           productos[productoAeliminar]=null;
           unidades[productoAeliminar]=0;
           System.out.println("\nEl producto fue eliminado satisfactoriamente\n");
           do{
           System.out.println("¿Desea volver a Elimiar algun otro producto? si=1, no=2");
           VolverAeliminar=numero.nextInt();
           if(VolverAeliminar>2||VolverAeliminar<1){PrintError();}
        }while(VolverAeliminar>2||VolverAeliminar<1);
        }while(VolverAeliminar==1);
        do{
        System.out.println("1. Volver al menu principal");
        System.out.println("2. Facturar");
        System.out.println("3. Salir");
        optionMenuElimiar=numero.nextInt();
        if(optionMenuElimiar>3||optionMenuElimiar<1){PrintError();}
        if(optionMenuElimiar==1){opcvolver=6;}else if (optionMenuElimiar==2){PrintFactura();}else if(optionMenuElimiar==3){printdespedida(); System.exit(0);}
    }while(optionMenuElimiar>3||optionMenuElimiar<1);
            }
        if(opcionMenuCompra==5){
            do{
            System.out.println("¿Esta seguro de que desea cancelar todas las compras? si=1, no=2");
            confirmacion=numero.nextInt();
            if(confirmacion>2||confirmacion<1){PrintError();}
        }while(confirmacion>2||confirmacion<1);
        if(confirmacion==2){
            do{
            System.out.println("1. Volver al menu principal");
            System.out.println("2. Facturar");
            System.out.println("3. Salir");
            CancelarFalse=numero.nextInt();
            if(CancelarFalse==1){opcvolver=6;}else if(CancelarFalse==2){PrintFactura();}else if(CancelarFalse==3){printdespedida(); System.exit(0);}
            if(CancelarFalse>3||CancelarFalse<1){PrintError();}
        }while(CancelarFalse>3||CancelarFalse<1);
        }
        if(confirmacion==1){
            for(int i =0;i<=contador2;i++){
            productos[i]=null;
            unidades[i]=0;
        }
        System.out.println("\nlos productos fueron removidos correctamente\n");
        do{
        System.out.println("1. Volver al menu principal");
        System.out.println("2. Salir");
        CancelarTrue=numero.nextInt();
       if(CancelarTrue==1){opcvolver=6;}else if(CancelarTrue==2){printdespedida(); System.exit(0);}
        if(CancelarTrue<1||CancelarTrue>2){PrintError();}
    }while(CancelarTrue<1||CancelarTrue>2);
    }
        }
    }while(opcionMenuCompra>5||opcionMenuCompra<1);
    }
    void PrintDatosFactura(){
        System.out.println("----------------------------------------------------------");
        System.out.println("            EL BUEN GUSTO S.A");
        System.out.println("     restaurante el buen gusto NO.10");
        System.out.println("                FACTURA");
        System.out.println("      fecha de emicion: 05/30/2020");
        System.out.println("      factura a nombre de: "  +nameUser);
        if (numNIT != 0) {
           System.out.println("                  NIT: " + numNIT);
        } else {
            System.out.println("                  NIT: NO");
        }
        System.out.println("    2av zona 4-102 Patzicia/Chimaltenango     ");
        System.out.println("             tel:19201821 ");
        System.out.println("");
        System.out.println("total   cant.  producto");
    }
    void DataOfUser(){
        System.out.println("\n--DATOS DEL USUARIO--");
        System.out.println("llene los siguientes datos para continuar\n");
        System.out.print("Facturar a nombre de: ");
        nameUser=scanner.nextLine();
        do{
        System.out.println("¿Posee numero de NIT? si=1 ,no=2");
        valNIT=numero.nextInt();
        if(valNIT>2||valNIT<1){PrintError();}
        if(valNIT==1){
            System.out.print("introduzca su numero de NI: ");
            numNIT=numero.nextInt();
        }
    }while(valNIT>2||valNIT<1);
    do{
        System.out.println("---------------------------------------------------------------");
        System.out.println("Total de gastos: Q"+TOTAL);
        System.out.print("ingrese su pago: Q");
        pago=numero.nextInt();
        if(pago<TOTAL){
            System.out.println("---------------------------------------------------------------");
            System.out.println("error ingrese un monto de pago mayor al total de sus compras");
        }
    }while(pago<TOTAL);
    }
    void PrintFactura(){
        Total();
        if(TOTAL>0){
        DataOfUser();
        PrintDatosFactura();   
        for(int i = 1;i<totalDeComprasRealizadas;i++){    
            if(productos[i]!=null){           
            System.out.println("Q" + unidades[i] * Precios[i] + "      " + unidades[i] + "     -" + productos[i]+ "---Q" + Precios[i]);
        }
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("TOTAL: Q"+TOTAL);
        System.out.println("pago con: Q"+pago);
        vuelto=pago-TOTAL;
        System.out.println("Vuelto: Q"+vuelto);
        printdespedida();
    }else{
        System.out.println("---------------------------------------------------------------");
        System.out.println("\nError no hay productos agregados");
    do{
    System.out.println("1. Volver al menu principal");
    System.out.println("2. salir");
    System.out.print("ingrese:");
    optionmenuerror=numero.nextInt();
    if(optionmenuerror==1){opcvolver=6;}else if(optionmenuerror==2){ printdespedida();System.exit(0);}
    if(optionmenuerror>2||optionmenuerror<1){PrintError();}
}while(optionmenuerror>2||optionmenuerror<1);
}
    }
    public static void main(String[] args) {        
        Main main= new Main();
        Scanner numero= new Scanner(System.in);        
        int optionstartmenu,optionTimeEat=0,salirprograma=0;
        do{
            main.opcionMenuCompra=0;
            optionstartmenu=0;
            salirprograma=0;
            optionTimeEat=0;
            main.opcvolver=0;
        System.out.println("--------------------------------------------RESTAURANTE EL BUEN GUSTO--------------------------------------------");
        System.out.println("1. Tiempos de comida");
        System.out.println("2. Bebidas");
        System.out.println("3. Postre");
        System.out.println("4. Salir");
        System.out.print("digite el numero de la opcion a la cual desea ingresar : ");    
        optionstartmenu=numero.nextInt();
       // main.AgregarProducto();
        switch (optionstartmenu) {
            case 1:{
                do{
                System.out.println("---TIEMPOS DE COMIDA---");
                System.out.println("1. Desayuos");
                System.out.println("2. Almuerzos");
                System.out.println("3. Cenas");
                System.out.println("4. Volver al menu principal");
                System.out.print("Eliga la opcion la cual desea ingresar: ");
                optionTimeEat=numero.nextInt();
                if(optionTimeEat>4||optionTimeEat<1){main.PrintError();}
            }while(optionTimeEat>4||optionTimeEat<1);
                switch (optionTimeEat) {
                    case 1:{
                        System.out.println("------------------------------------------DESAYUNOS------------------------------------------");
                        main.mostrar(main.vecdesayuno, main.preciodesayuno, main.optionDesayuno,5);
                        break;
                    }
                    case 2:{
                        System.out.println("------------------------------------------ALMUERZOS------------------------------------------");
                        main.mostrar(main.vecalmuerzo, main.precioalmuerzo, main.optionAlmuerzo,5);
                        break;
                    }
                    case 3 :{
                        System.out.println("------------------------------------------CENAS------------------------------------------");
                        main.mostrar(main.veccena, main.preciocena, main.optionCena,5);
                        break;
                    }
                    default:{
                        main.PrintError();
                        break;
                    }               
                }
                break;
            }
            case 2 :{
                System.out.println("------------------------------------------BEBIDAS------------------------------------------");
                main.mostrar(main.vecbebidas, main.preciobebida, main.optionBebida,10);
                break;
            }
            case 3 :{
                System.out.println("------------------------------------------POSTRES------------------------------------------");
                main.mostrar(main.vecpostre, main.preciopostre, main.optionPostre,10);
                break;
            }
            case 4 :{
                do{
                System.out.println("¿ESTA SEGURO DE ABANDNAR EL PROGRAMA? si=1, no=2");
                System.out.print("digite: ");
                salirprograma=numero.nextInt();
                if(salirprograma>2||salirprograma<1){main.PrintError();}
            }while(salirprograma>2||salirprograma<1);
            if(salirprograma==1){
            main.printdespedida();
            System.exit(0);
        }
            }
            default:{
               main.PrintError();
                break;
            }
        }
    }while(main.opcionMenuCompra==2||optionstartmenu>4||optionstartmenu<1||salirprograma==2||optionTimeEat==4||main.opcvolver==6||main.opcvolver==11);
    }
    void PrintError()
    {
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("Error esta opcion no esta disponible");
        System.out.println("---------------------------------------");
        System.out.println("volviendo a mostrar...");
        System.out.println();
    }
    void printdespedida(){
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("MUCHAS GRACIAS POR VISITARNOS , VUELVA PRONTO");
        System.out.println("------------------------------------------------");
    }   
}