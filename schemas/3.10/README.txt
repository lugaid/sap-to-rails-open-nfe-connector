The version of these xsd is PL_008i

I've commented line 3249 of leiauteNFe_v3.10.xsd to don't generate catch-all into xjc command.

After class generation you need to add the annotation @XmlRootElement(name = "NFe") to TNFe class.