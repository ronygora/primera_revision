<%-- 
    Document   : index
    Created on : 16/09/2020, 15:53:07
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modeloMedicina.Medicina" %>
<%@page import="modeloMedicina.Tipo"%>
<%@page import="java.util.HashMap"%>
<%@page import="javax.swing.table.DefaultTableModel"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        
    </head>
    <body>
        <h1>Formulario Medicina</h1>
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modal_medicina" onclick="limpiar()">Nuevo</button>
        <button type="button" class="btn btn-info btn-lg" href="" ><a href="index.jsp">Paciente</a></button>
        <button type="button" class="btn btn-info btn-lg" href="" ><a href="index_1.jsp">Personal</a></button>
    <div class="container">
          <div class="modal fade" id="modal_medicina" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
            <form action="sr_medicina" method="post" class="form-group">
               <label for="lbl_id" ><b>ID</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value="0"  readonly> 
                <label for="lbl_nombre_medicina" ><b>Nombre Medicina</b></label>
                <input type="text" name="txt_nombre_medicina" id="txt_nombre_medicina" class="form-control" placeholder="Ejemplo: Aspirina" required>
                <label for="lbl_tipo_medicina" ><b>Tipo de Medicina</b></label>
                <select name="drop_tipo_medicina" id="drop_tipo_medicina" class="form-control">
                    <%
                        Tipo tipo = new Tipo();
                        HashMap<String,String> drop = tipo.drop_tipo();
                        for(String i: drop.keySet()){
                        out.println("<option value = '" + i + "'>" + drop.get(i) +"</option>");
                        }
                        
                    %>

                </select>
                
                <label for="lbl_lote_medicina" ><b>Lote</b></label>
                <input type="text" name="txt_lote_medicina" id="txt_lote_medicina" class="form-control" placeholder="Ejemplo:2020-15-20" required>
                <label for="lbl_descripcion_medicina" ><b>Descripcion</b></label>
                <input type="text"  name="txt_descripcion_medicina" id="txt_descripcion_medicina" class="form-control" placeholder="Ejemplo:pastilla para aliviar el dolor de cabeza" required>
                <label for="lbl_existencia" ><b>Existencia</b></label>
                <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="Ejemplo: 100" required>
               
              
                <br>
                <button name="btn_agregar" id="btn_agregar"  value="agregar" class="btn btn-primary btn-lg">Agregar</button>
                <button name="btn_modificar" id="btn_modificar"  value="modificar" class="btn btn-success btn-lg">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar"  value="eliminar" class="btn btn-danger btn-lg" onclick="javascript:if(!confirm('¿Desea Eliminar?'))return false" >Eliminar</button>
                <button type="button" class="btn btn-warning btn-lg" data-dismiss="modal">Cerrar</button>
            </form>
        </div>
      </div>
    </div>
    </div>

 <table class="table table-striped">
    <thead>
      <tr>
        <th>Nombre Medicina</th>
        <th>Tipo Medicina</th>
        <th>Lote</th>
        <th>Descripcion</th>
        <th>Existencia</th>
    
      </tr>
    </thead>
    
    <tbody id="tbl_medicina">
        <% 
        Medicina medicina = new Medicina();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = medicina.leer();
        for (int t=0;t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_t=" + tabla.getValueAt(t,3) + ">");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("</tr>");
        
        }
        %>
      
    </tbody>
  </table>
     

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script type="text/javascript">

     function limpiar(){
       $("#txt_id").val(0);
       $("#txt_nombre_medicina").val('');
       $("#txt_drop_medicina").val(1);
       $("#txt_lote_medicina").val('');
       $("#txt_descripcion_medicina").val('');
       $("#txt_existencia").val('');
      
    }
    
    $('#tbl_medicina').on('click','tr td',function(evt){

        var target,id,id_t,nombres,lote,descripcion,existencia; 
       target = $(event.target);
       id = target.parent().data('id');
       id_t = target.parent().data('id_t'); 
       nombres= target.parent("tr").find("td").eq(0).html();
       lote = target.parent("tr").find("td").eq(2).html();
       descripcion = target.parent("tr").find("td").eq(3).html();
       existencia = target.parent("tr").find("td").eq(4).html();
       
       $("#txt_id").val(id);
       $("#txt_nombre_medicina").val(nombres);
       $("#drop_tipo_medicina").val(id_t);
       $("#txt_lote_medicina").val(lote);
       $("#txt_descripcion_medicina").val(descripcion);
       $("#txt_existencia").val(existencia);
       $("#modal_medicina").modal('show');
    });
    
</script>
    </body>
</html>
