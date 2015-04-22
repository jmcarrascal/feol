package jmc.feol.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


import jmc.feol.core.model.Factura;




import FEV1.dif.afip.gov.ar.AlicIva;
import FEV1.dif.afip.gov.ar.FECAECabRequest;
import FEV1.dif.afip.gov.ar.FECAEDetRequest;
import FEV1.dif.afip.gov.ar.FECAERequest;
import FEV1.dif.afip.gov.ar.Tributo;

public class ParseFactura {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FECAERequest comprobanteType = ParseFactura
				.parseFacturaABv1("C:/CoinseFE/Coinse.FEDesa/Definitivo/A01000300000001.txt");
		System.out.println("");
	}

	public static FECAERequest parseFacturaABv1(String rutaArchivo) {
		FECAERequest feReq = new FECAERequest();
		BufferedReader entrada = null;
		try {
			entrada = new BufferedReader(new FileReader(rutaArchivo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String devolver = "";
		String[] listaParametros = null;

		List<Tributo> tributoList = new ArrayList<Tributo>();
		List<AlicIva> alicIvaList = new ArrayList<AlicIva>();

		FECAECabRequest feCabecera = new FECAECabRequest();
		FECAEDetRequest feDetalle = new FECAEDetRequest();

		feCabecera.setCantReg(1);

		Boolean read = Boolean.TRUE;
		while (read) {
			try {

				if ((devolver = entrada.readLine()) == null
						|| devolver.length() == 0)
					break;
				// String algo = devolver.substring(0, 1);
				if (devolver.substring(0, 1).equals("1")) {
					devolver = devolver.substring(1);
					listaParametros = devolver.split("\\|");
					int i = 0;

					while (listaParametros.length > i) {
						switch (i) {
						case 1:
							try {
								feDetalle.setConcepto(Integer
										.parseInt(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 2:
							try {
								feDetalle.setDocTipo(Integer
										.parseInt(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 3:
							try {
								feDetalle.setDocNro(Long
										.parseLong(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 4:
							try {
								feCabecera.setCbteTipo(Integer
										.parseInt(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 5:
							try {
								feCabecera.setPtoVta(Integer
										.parseInt(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 6:
							try {
								feDetalle.setCbteDesde(Long
										.parseLong(listaParametros[i]));
								feDetalle.setCbteHasta(Long
										.parseLong(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 7:
							try {
								feDetalle.setCbteFch(listaParametros[i]);
							} catch (Exception e) {
							}
							break;
						case 8:
							try {
								feDetalle.setImpTotal(Double
										.parseDouble(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 9:
							try {
								feDetalle.setImpTotConc(Double
										.parseDouble(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 10:
							try {
								feDetalle.setImpNeto(Double
										.parseDouble(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 11:
							try {
								feDetalle.setImpOpEx(Double
										.parseDouble(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 12:
							try {
								feDetalle.setImpIVA(Double
										.parseDouble(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 13:
							try {
								feDetalle.setImpTrib(Double
										.parseDouble(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 14:
							try {
								feDetalle.setFchServDesde(listaParametros[i]);
							} catch (Exception e) {
							}
							break;
						case 15:
							try {
								feDetalle.setFchServHasta(listaParametros[i]);
							} catch (Exception e) {
							}
							break;
						case 16:
							try {
								feDetalle.setFchVtoPago(listaParametros[i]);
							} catch (Exception e) {
							}
							break;
						case 17:
							try {
								feDetalle.setMonId(listaParametros[i]);
							} catch (Exception e) {
							}
							break;
						case 18:
							try {
								feDetalle.setMonCotiz(Double
										.parseDouble(listaParametros[i]));
							} catch (Exception e) {
							}
							break;
						case 19:
							try {
								feReq.setNumeroInterno(listaParametros[i]);
							} catch (Exception e) {}
							break;
						}
						i++;					
				}
			}
			if (devolver.substring(0, 1).equals("2")) {
				devolver = devolver.substring(1);
				listaParametros = devolver.split("\\|");
				int j = 0;
				Tributo tributo = new Tributo();
				while (listaParametros.length > j) {
					switch (j) {
					case 1:
						try {
							tributo.setId(Short.parseShort(listaParametros[j]));
						} catch (Exception e) {
						}
						break;
					case 2:
						try {
							tributo.setDesc(listaParametros[j]);
						} catch (Exception e) {
						}
						break;
					case 3:
						try {
							tributo.setBaseImp(Double
									.parseDouble(listaParametros[j]));
						} catch (Exception e) {
						}
						break;
					case 4:
						try {
							tributo.setAlic(Double
									.parseDouble(listaParametros[j]));
						} catch (Exception e) {
						}
						break;
					case 5:
						try {
							tributo.setImporte(Double
									.parseDouble(listaParametros[j]));
						} catch (Exception e) {
						}
						break;
					}
					j++;
				}
				tributoList.add(tributo);
			}
			if (devolver.substring(0, 1).equals("3")) {
				devolver = devolver.substring(1);
				listaParametros = devolver.split("\\|");
				int a = 0;
				AlicIva alicIva = new AlicIva();
				while (listaParametros.length > a) {
					switch (a) {
					case 1:
						try {
							alicIva.setId(Integer.parseInt(listaParametros[a]));
						} catch (Exception e) {
						}
						break;
					case 2:
						try {
							alicIva.setBaseImp(Double
									.parseDouble(listaParametros[a]));
						} catch (Exception e) {
						}
						break;
					case 3:
						try {
							alicIva.setImporte(Double
									.parseDouble(listaParametros[a]));
						} catch (Exception e) {
						}
						break;
					}
					a++;
				}
				alicIvaList.add(alicIva);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	if (listTributoToArray(tributoList).length > 0)
		feDetalle.setTributos(listTributoToArray(tributoList));
	if (listAlicIvaToArray(alicIvaList).length > 0)
		feDetalle.setIva(listAlicIvaToArray(alicIvaList));

	feReq.setFeCabReq(feCabecera);
	FECAEDetRequest[] detalles = new FECAEDetRequest[1];
	detalles[0] = feDetalle;
	feReq.setFeDetReq(detalles);
	return feReq;
	}

	
	private static Tributo[] listTributoToArray(
			List<Tributo> list) {
		Tributo[] array = new Tributo[list.size()];
		int i = 0;
		for (Tributo tributo : list) {
			array[i] = tributo;
			i++;
		}
		return array;
	}

	private static AlicIva[] listAlicIvaToArray(List<AlicIva> listAlicIva) {
		AlicIva[] alicIvaArray = new AlicIva[listAlicIva.size()];
		int i = 0;
		for (AlicIva alicIva : listAlicIva) {
			alicIvaArray[i] = alicIva;
			i++;
		}
		return alicIvaArray;
	}
	
	public static String getOutDataFactura(Factura factura){
		String result = "";		
		
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCae()), 14));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCae_vto()), 8));
		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getTipo_cbte()), 3));
		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getPunto_vta()), 4));
		result = result + FileUtil.sinNull(FileUtil.llenoConCeros(String.valueOf(factura.getCbt_desde()), 8));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getCodError()), 50));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getReproceso()), 1));
		String motivo = factura.getResultado();
		if (motivo.length() > 150){
			motivo = motivo.substring(0, 150);
		}
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(motivo, 150));
		result = result + FileUtil.sinNull(FileUtil.llenoConEspacios(String.valueOf(factura.getNumeroInterno()), 14));
		System.out.println("Mensaje: " + result);
		return result;
	}
}
