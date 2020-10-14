<%-- 
    Document   : index
    Created on : 11/08/2020, 15:53:07
    Author     : Usuario
--%>

<%@page import="modeloPersonal.Puesto" %>
<%@page import="modeloPersonal.Personal" %>
<%@page import="java.util.HashMap" %>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Formulario Personal</h1>
        
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_personal" onclick="limpiar()">Nuevo</button>
        <button type="button" class="btn btn-info btn-lg" href="" ><a href="index.jsp">Paciente</a></button>
        <button type="button" class="btn btn-info btn-lg" href="" ><a href="index_2.jsp">Medicina</a></button>
    <div class="container">
          <div class="modal fade" id="modal_personal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_per" method="post" class="form-group">
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
                <label for="lbl_nombre_personal" ><b>Nombre</b></label>
                <input type="text" name="txt_nombre_personal" id="txt_nombre_personal" class="form-control" placeholder="Ejemplo: Nombre1 Nombre2" required>
                <label for="lbl_apellido_personal" ><b>Apellido</b></label>
                <input type="text" name="txt_apellido_personal" id="txt_apellido_personal" class="form-control" placeholder="Ejemplo: Apellido1 Apellido2" required>
                <label for="lbl_telefono_personal" ><b>Telefono</b></label>
                <input type="number" name="txt_telefono_personal" id="txt_telefono_personal" class="form-control" placeholder="Ejemplo: 5555555" required>
                <label for="lbl_direccion_personal" ><b>Direccion</b></label>
                <input type="text"  name="txt_direccion_personal" id="txt_direccion_personal" class="form-control" placeholder="Ejemplo: #Casa calle zona ciudad" required>
                <label for="lbl_puesto" ><b>Puesto</b></label>
                <select name="drop_puesto" id="drop_puesto" class="form-control">
                    <% 
                        Puesto puesto = new Puesto();
                        HashMap<String,String> drop = puesto.drop_puesto();
                         for (String i:drop.keySet()){
                             out.println("<option value='" + i + "'>" + drop.get(i) + "</option>");
                         }
                    %>
                </select>
                <br>
                <button name="btn_agregar1" id="btn_agregar1"  value="agregar1" class="btn btn-primary btn-lg">Agregar</button>
                <button name="btn_modificar1" id="btn_modificar1"  value="modificar1" class="btn btn-success btn-lg">Modificar</button>
                <button name="btn_eliminar1" id="btn_eliminar1"  value="eliminar1" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" >Eliminar</button>
                <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
            </form>
        </div>
      </div>
      
    </div>
  </div>
        
        
           
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Telefono</th>
        <th>Direccion</th>
        <th>Puesto</th>
      </tr>
    </thead>
    <tbody id="tbl_personal">
        <% 
        Personal personal = new Personal();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = personal.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_p=" + tabla.getValueAt(t,6) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("</tr>");
        
        }
        %>
    </tbody>
  </table>
  </div>
      

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script type="text/javascript">
    
    function limpiar(){
       $("#txt_id").val(0);
       $("#txt_nombre_personal").val('');
       $("#txt_apellido_personal").val('');
       $("#txt_telefono_personal").val('');
       $("#txt_direccion_personal").val('');
       $("#drop_puesto").val(1);
    }
    
    $('#tbl_personal').on('click','tr td',function(evt){
       var target,id,id_p,nombre_personal,apellido_personal,telefono_personal,direccion_personal; 
       target = $(event.target);
       id = target.parent().data('id');
       id_p = target.parent().data('id_p'); 
       nombre_personal = target.parent("tr").find("td").eq(0).html();
       apellido_personal = target.parent("tr").find("td").eq(1).html();
       telefono_personal = target.parent("tr").find("td").eq(2).html();
       direccion_personal = target.parent("tr").find("td").eq(3).html();
       $("#txt_id").val(id);
       $("#txt_nombre_personal").val(nombre_personal);
       $("#txt_apellido_personal").val(apellido_personal);
       $("#txt_telefono_personal").val(telefono_personal);
       $("#txt_direccion_personal").val(direccion_personal);
       $("#drop_puesto").val(id_p);
       $("#modal_personal").modal('show');
    });
    
</script>
    </body>
</html>
