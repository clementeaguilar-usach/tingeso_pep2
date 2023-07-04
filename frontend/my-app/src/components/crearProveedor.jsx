import React, {Component} from 'react';
import ProveedorService from '../services/ProveedorService';

class crearProveedor extends Component {

    constructor() {
        super();
        this.state = {
            nombre : null,
            categoria : null,
            retencion : null,
            codigo : null
        };
    }

    onNombreChange = (event) => {
        this.setState({
            nombre: event.target.value
        })
    }

    onCodigoProveedorChange = (event) => {
        this.setState({
            codigoProveedor: event.target.value
        })
    }

    onCategoriaChange = (event) => {
        this.setState({
            categoria: event.target.value
        })
    }

    onRetencionChange = (event) => {
        this.setState({
            retencion: event.target.value
        })
    }

    onClickHandler = (e) => {
        e.preventDefault();
        ProveedorService.cargarProveedor(this.state.nombre,
            this.state.codigoProveedor, this.state.categoria, this.state.retencion).then(res => {
            console.log(res);
        } );
    }

    render() {
        return (
            <div className= "container">
                <h1>Crear Proveedor</h1>
                <form>
                    <div className="form-group">
                        <label>Nombre Proveedor</label>
                        <input type="text" className="form-control" placeholder="Nombre Proveedor" onChange={this.onNombreChange}/>
                    </div>
                    <div className="form-group">
                        <label>Codigo Proveedor</label>
                        <input type="text" className="form-control" placeholder="Codigo Proveedor" onChange={this.onCodigoProveedorChange}/>
                    </div>
                    <div className="form-group">
                        <label>Categoria</label>
                        <input type="text" className="form-control" placeholder="Categoria" onChange={this.onCategoriaChange}/>
                    </div>
                    <div className="form-group">
                        <label>Retencion</label>
                        <input type="text" className="form-control" placeholder="Retencion" onChange={this.onRetencionChange}/>
                    </div>
                    <button type="submit" className="btnn btn-success btn-block" onClick={this.onClickHandler}>Cargar</button>
                </form>
            </div>
        );
    }

}
export default CargarProveedorComponent;