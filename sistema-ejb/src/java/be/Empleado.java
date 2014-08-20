/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombreEmpleado", query = "SELECT e FROM Empleado e WHERE e.nombreEmpleado = :nombreEmpleado"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo"),
    @NamedQuery(name = "Empleado.findByUsuario", query = "SELECT e FROM Empleado e WHERE e.usuario = :usuario"),
    @NamedQuery(name = "Empleado.findByPassword", query = "SELECT e FROM Empleado e WHERE e.password = :password"),
    @NamedQuery(name = "Empleado.findBySueldoBase", query = "SELECT e FROM Empleado e WHERE e.sueldoBase = :sueldoBase"),
    @NamedQuery(name = "Empleado.findByEstadoExistencia", query = "SELECT e FROM Empleado e WHERE e.estadoExistencia = :estadoExistencia")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empleado")
    private Integer idEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 150)
    @Column(name = "nombre_empleado")
    private String nombreEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 250)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 48)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 68)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 0, max = 170)
    @Column(name = "password")
    private String password;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "sueldo_base")
    private BigDecimal sueldoBase;
    @Column(name = "estado_existencia")
    private Integer estadoExistencia;
    @OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<GrupoUsuario> grupoUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ReporteDesratizacion> reporteDesratizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Promocion> promocionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PagoCompraCredito> pagoCompraCreditoList;
    @OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<FacturaCompra> facturaCompraList;
    @OneToMany(mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<PagoVentaCredito> pagoVentaCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<ReporteFumigacion> reporteFumigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.EAGER)
    private List<Venta> ventaList;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "id_tipo_empleado", referencedColumnName = "id_tipo_empleado")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEmpleado tipoEmpleado;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombreEmpleado, String direccion, String telefono, String correo, String usuario, String password) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(BigDecimal sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public Integer getEstadoExistencia() {
        return estadoExistencia;
    }

    public void setEstadoExistencia(Integer estadoExistencia) {
        this.estadoExistencia = estadoExistencia;
    }

    @XmlTransient
    public List<PagoFacturaVentaCredito> getPagoFacturaVentaCreditoList() {
        return pagoFacturaVentaCreditoList;
    }

    public void setPagoFacturaVentaCreditoList(List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList) {
        this.pagoFacturaVentaCreditoList = pagoFacturaVentaCreditoList;
    }

    @XmlTransient
    public List<GrupoUsuario> getGrupoUsuarioList() {
        return grupoUsuarioList;
    }

    public void setGrupoUsuarioList(List<GrupoUsuario> grupoUsuarioList) {
        this.grupoUsuarioList = grupoUsuarioList;
    }

    @XmlTransient
    public List<ReporteDesratizacion> getReporteDesratizacionList() {
        return reporteDesratizacionList;
    }

    public void setReporteDesratizacionList(List<ReporteDesratizacion> reporteDesratizacionList) {
        this.reporteDesratizacionList = reporteDesratizacionList;
    }

    @XmlTransient
    public List<PrestamoProductoTiendaUsuario> getPrestamoProductoTiendaUsuarioList() {
        return prestamoProductoTiendaUsuarioList;
    }

    public void setPrestamoProductoTiendaUsuarioList(List<PrestamoProductoTiendaUsuario> prestamoProductoTiendaUsuarioList) {
        this.prestamoProductoTiendaUsuarioList = prestamoProductoTiendaUsuarioList;
    }

    @XmlTransient
    public List<Promocion> getPromocionList() {
        return promocionList;
    }

    public void setPromocionList(List<Promocion> promocionList) {
        this.promocionList = promocionList;
    }

    @XmlTransient
    public List<PagoCompraCredito> getPagoCompraCreditoList() {
        return pagoCompraCreditoList;
    }

    public void setPagoCompraCreditoList(List<PagoCompraCredito> pagoCompraCreditoList) {
        this.pagoCompraCreditoList = pagoCompraCreditoList;
    }

    @XmlTransient
    public List<FacturaCompra> getFacturaCompraList() {
        return facturaCompraList;
    }

    public void setFacturaCompraList(List<FacturaCompra> facturaCompraList) {
        this.facturaCompraList = facturaCompraList;
    }

    @XmlTransient
    public List<PagoVentaCredito> getPagoVentaCreditoList() {
        return pagoVentaCreditoList;
    }

    public void setPagoVentaCreditoList(List<PagoVentaCredito> pagoVentaCreditoList) {
        this.pagoVentaCreditoList = pagoVentaCreditoList;
    }

    @XmlTransient
    public List<ReporteFumigacion> getReporteFumigacionList() {
        return reporteFumigacionList;
    }

    public void setReporteFumigacionList(List<ReporteFumigacion> reporteFumigacionList) {
        this.reporteFumigacionList = reporteFumigacionList;
    }

    @XmlTransient
    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Empleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
