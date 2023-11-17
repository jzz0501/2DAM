SELECT pv.nombre_prov, pd.nombre_prod, pd.precio FROM proveedores pv, productos pd WHERE pd.cod_prov = pv.cod_prov AND pd.precio > 2000 ORDER BY pd.precio DESC
SELECT pv.nombre_prov, pv.telefono, pd.nombre_prod FROM proveedores pv, productos pd WHERE pv.cod_prov = pd.cod_prov AND pd.nombre_prod LIKE '%ordenador%'
SELECT pd.nombre_prod, pd.stock FROM productos pd WHERE pd.stock < 20
SELECT pv.nombre_prov, COUNT(pd.cod_prod) count_prod, AVG(pd.precio) avg_precio FROM proveedores pv, productos pd WHERE pv.cod_prov = pd.cod_prov GROUP BY pv.cod_prov
SELECT v.nombre_prov, direccion, telefono, MAX(stock) max_stock FROM proveedores v, productos p WHERE v.cod_prov = p.cod_prov GROUP BY v.nombre_prov, direccion, telefono
