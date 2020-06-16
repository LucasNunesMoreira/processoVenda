package dev.lucas.procss.controllers;

import dev.lucas.procss.models.Venda;
import dev.lucas.procss.models.Vendedor;
import dev.lucas.procss.repository.VendaRepository;
import dev.lucas.procss.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class VendedorController {

    @Autowired
    private VendedorRepository vendedorReposit;
    @Autowired
    private VendaRepository vendaReposit;


    @RequestMapping(value = "/registrarVendedor", method = RequestMethod.GET)
    public String form() {

        return "vendas/registrarVendedor";
    }

    @RequestMapping(value = "/registrarVendedor", method = RequestMethod.POST)
    public String form(Vendedor vendedor) {
        vendedorReposit.save(vendedor);

        return "redirect:/registrarVendedor";
    }


    @RequestMapping("/selectVendedor")
    public ModelAndView listaVendedores() {
        ModelAndView mv = new ModelAndView("vendas/selectVendedor");
        Iterable<Vendedor> vendedores = vendedorReposit.findAll();
        mv.addObject("vendedores", vendedores);

        return mv;
    }

    @RequestMapping(value = "/{idVendedor}", method = RequestMethod.GET)
    public ModelAndView filtrarVendedorGet(@PathVariable("idVendedor") long idVendedor) {
        Vendedor vendedor = vendedorReposit.findByidVendedor(idVendedor);
        ModelAndView mv = new ModelAndView("vendas/realizarVenda");
        mv.addObject("vendedor", vendedor);

        return mv;
    }

    @RequestMapping(value = "/{idVendedor}", method = RequestMethod.POST)
    public String filtrarVendedorPost(@PathVariable("idVendedor") long idVendedor, Venda venda) {
        Vendedor vendedor = vendedorReposit.findByidVendedor(idVendedor);
        venda.setNomeVendedor(vendedor);
        vendaReposit.save(venda);

        return "redirect:/{idVendedor}";
    }

    @RequestMapping(value = "/visaoGeral", method = RequestMethod.GET)
    public String visaoGeral() {

        return "vendas/visaoGeral";
    }


    @RequestMapping(value = "/visaoGeral", method = RequestMethod.POST)
    public ModelAndView filtroVendedores(String inicio, String fim) {
        ModelAndView mv = new ModelAndView("vendas/visaoFiltrada");

        Iterable<Venda> vendas = vendaReposit.findAllBydataVendaBetween(inicio, fim);
        mv.addObject("vendas", vendas);

        //vendas = vendaReposit.findAllgroupByvendedor();

        ArrayList<Long> totalVendas = vendaReposit.countBydataVendaBetween(inicio, fim);
        mv.addObject("totalVendas", totalVendas);

        //long mediaVendas = vendaRepositfindAllBydataVendaBetween;
        //mv.addObject("mediaVendas", mediaVendas);

        return mv;
    }
}
