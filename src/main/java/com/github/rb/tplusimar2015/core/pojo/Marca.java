package com.github.rb.tplusimar2015.core.pojo;

public enum Marca {

    ACURA(1, "Acura"),
    ALFA_ROMEO(2, "Alfa Romeo"),
    ASTON_MARTIN(3, "Aston Martin"),
    AUDI(4, "Audi"),
    BENTLEY(5, "Bentley"),
    BMW(6, "BMW"),
    BUGATTI(7, "Bugatti"),
    CADILLAC(8, "Cadillac"),
    CITROEN(9,"Citroen"),
    CHEVROLET(10, "Cheverolet"),
    CHRYSLER(11, "Chrysler"), 
    DAEWOO(12, "Daewoo"), 
    DAIHATSU(13, "Daihatsu"), 
    DODGE(14, "Dodge"), 
    FERRARI(15, "Ferrari"), 
    FIAT(16, "Fiat"), 
    FORD(17, "Ford"), 
    GENERAL_MOTOR_COMPANY(18, "General Motors Company"), 
    HOLDEN(19, "Holden"), 
    HONDA(20,"Honda"), 
    HUMMER(21, "Hummer"), 
    HYUNDAI(22, "Hyundai"), 
    INFINITY(23, "Infinity"), 
    ISUZU(24, "Isuzu"), 
    JAGUAR(25, "Jaguar"), 
    JEEP(26,"Jeep"), 
    KIA(27, "Kia"), 
    KOENIGSEGG(28, "Koenigsegg"), 
    LAMBORGHINI(29, "Lamborghini"), 
    LANCIA(30, "Lancia"), 
    LAND_ROVER(31,"Land Rover"), 
    LEXUS(32, "Lexus"), 
    LINCOLN(33, "Lincoln"), 
    LOTUS(34, "Lotus"), 
    MASERATI(35, "Maserati"), 
    MAZDA(36, "Mazda"), 
    MC_LAREN(37, "Mc Laren"), 
    MERCEDES_BENZ(38, "Mercedes Benz"), 
    MERCURY(39,"Mercury"), 
    MG(40, "MG"), 
    MINI(41, "Mini"), 
    MITSUBISHI(42,"Mitsubishi"), 
    NISSAN(43, "Nissan"), 
    OLDSMOBILE(44, "Oldsmobile"), 
    OPEL(45, "Opel"), 
    PAGANI(46, "Pagani"), 
    PEUGEOT(47, "Peugeot"), 
    PININFARINA(48, "Pinifarina"), 
    PLYMOUTH(49, "Plymouth"), 
    PONTIAC(50, "Pontiac"), 
    PORSCHE(51, "Porsche"), 
    PROTON(52, "Proton"), 
    RENAULT(53, "Renault"), 
    ROLLS_ROYCE(54, "Rolls Royce"), 
    ROVER(55, "Rover"), 
    SAAB(56, "Saab"), 
    SATURN(57, "Saturn"), 
    SCANIA(58, "Scania"), 
    SEAT(59, "Seat"), 
    SHELBY(60,"Shelby"), 
    SKODA(61, "Skoda"), 
    SMART(62, "Smart"), 
    SSANGYONG(63,"Ssangyong"), 
    SUBARU(64, "Subaru"), 
    SUZUKI(65, "Suzuki"), 
    TOYOTA(66, "Toyota"), 
    VAUXHALL(67, "Vauxhall"), 
    VENTURI(68, "Venturi"), 
    VOLVO(69, "Volvo"), 
    VOLKSWAGEN(70, "Volskwagen");

    private final Integer codigo;
    private final String nombre;

    private Marca(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public static Marca getMarca(Integer codigo) {

        for (Marca marca : Marca.values()) { //REFACTORIZAR
            if (codigo == marca.getCodigo()) {
                return marca;
            }
        }
        return null;
    }

    public static Marca getMarca(String nombre) {

        for (Marca marca : Marca.values()) {
            if (nombre == marca.getNombre()) {
                return marca;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
