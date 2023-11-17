INSERT ALL
 INTO proveedores (cod_prov, nombre_prov, direccion, telefono, bonifica) VALUES ('1','proveedor 1','direccion 1','123456789',0)
 INTO proveedores (cod_prov, nombre_prov, direccion, telefono, bonifica) VALUES ('2','proveedor 2','direccion 2','123456789',20)
 INTO proveedores (cod_prov, nombre_prov, direccion, telefono, bonifica) VALUES ('3','proveedor 3','direccion 3','123456789',30)
 INTO proveedores (cod_prov, nombre_prov, direccion, telefono, bonifica) VALUES ('4','proveedor 4','direccion 4','123456789',40)
 INTO proveedores (cod_prov, nombre_prov, direccion, telefono, bonifica) VALUES ('5','proveedor 5','direccion 5','123456789',50)
 INTO productos (cod_prod, nombre_prod, precio, stock, cod_prov) VALUES ('1','portatil',2200,15,'5')
 INTO productos (cod_prod, nombre_prod, precio, stock, cod_prov) VALUES ('2','ordenador',2100,25,'4')
 INTO productos (cod_prod, nombre_prod, precio, stock, cod_prov) VALUES ('3','PS5',3000,22,'3')
 INTO productos (cod_prod, nombre_prod, precio, stock, cod_prov) VALUES ('4','ordenador',1500,10,'2')
 INTO productos (cod_prod, nombre_prod, precio, stock, cod_prov) VALUES ('5','ordenador',1600,5,'1')
 INTO productos (cod_prod, nombre_prod, precio, stock, cod_prov) VALUES ('6','portatil',2200,15,'1')
 INTO productos (cod_prod, nombre_prod, precio, stock, cod_prov) VALUES ('7','ordenador',2100,25,'2')
 SELECT 1 FROM dual