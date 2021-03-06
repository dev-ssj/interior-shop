package kr.spring.order.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.cart.service.CartService;
import kr.spring.cart.vo.CartVO;
import kr.spring.cart.vo.ProductCartVO;
import kr.spring.delivery.service.DeliveryService;
import kr.spring.delivery.vo.DeliveryVO;
import kr.spring.member.service.MemberService;
import kr.spring.member.vo.MemberVO;
import kr.spring.order.service.OrderService;
import kr.spring.order.vo.OrderAllVO;
import kr.spring.order.vo.OrderListVO;
import kr.spring.order.vo.OrderVO;
import kr.spring.orderDetail.service.OrderDetailService;
import kr.spring.orderDetail.vo.OrderDetailVO;
import kr.spring.product.service.ProductService;
import kr.spring.product.vo.ProductVO;
import kr.spring.util.PagingUtil;

@Controller
public class OrderController {
	private int rowCount = 5;
	private int pageCount = 10;
	
		private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
		@Autowired
		private CartService cartService;		
		@Autowired(required = true)
		private OrderService orderService;		
		@Autowired
		private OrderDetailService orderDetailService;		
		@Autowired
		private MemberService memberService;
		@Autowired
		private DeliveryService deliveryService;
		@Autowired
		private ProductService productService;
		
		//?????????(VO) ?????????
		@ModelAttribute("orderVO")
		public OrderVO initCommand() {
			return new OrderVO();
		}

	  //?????????????????? ??????????????? ?????? 
	  @GetMapping("/shop/order.do") 
	  public ModelAndView insertOrderForm(HttpSession session) { 
		  
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  List<ProductCartVO> list = cartService.selectCart(mem_num);
		  
		  if(list.isEmpty()) {
			  return new ModelAndView("/common/notice");
		  }
		  
		  MemberVO member = memberService.selectMember(mem_num);
		  ModelAndView mav = new ModelAndView();
		  mav.setViewName("shopOrder");
		  mav.addObject("cartList",list);
		  mav.addObject("member",member);
		  return mav;
	  }
	  
	  //?????????????????? ?????? insert
	  @PostMapping("/shop/order.do")
	  public String insertOrder(HttpSession session, OrderVO orderVO, OrderDetailVO orderDetailVO) {
		  DeliveryVO deliveryVO = new DeliveryVO();
		  
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  
		  //???????????? ?????? (yyyymmdd_??????6??????)
		  Calendar cal = Calendar.getInstance();
		  int year = cal.get(Calendar.YEAR);
		  String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		  String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		  String subNum = "";
			 
		  for(int i = 1; i <= 6; i ++) {
			  subNum += (int)(Math.random() * 10);
		  }
			 
		  String orderNo = ymd + "_" + subNum;

		  orderVO.setOrder_no(orderNo); //????????????
		  orderVO.setMem_num(mem_num); //????????????
		  
		  orderDetailVO.setOrder_no(orderNo);
		  orderDetailVO.setMem_num(mem_num);
		  
		  deliveryVO.setOrder_no(orderNo);	  
		  
		  //??????????????? insert, ????????????????????? insert, ??????????????? insert, ?????? ?????? update, ???????????? ?????? delete
		  orderService.insertCartOrder(orderVO,orderDetailVO,orderNo);
		  
		  return "redirect:/shop/orderResult.do";
	  }
	  
	  //??????????????????????????? ??????????????? ??????
	  @RequestMapping("/shop/orderNow.do")
	  public ModelAndView insertDirectOrderForm(HttpSession session, @RequestParam int p_no, int cart_amount) { 
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  MemberVO member = memberService.selectMember(mem_num);
		  
		  ProductVO product = productService.productSelect(p_no);
		  int count = productService.countProduct(p_no);
		 
		  //?????? ????????? ????????? notice????????? ??????
		  if(count == 0) {
			  return new ModelAndView("/common/notice");
		  }
		  //????????? ???????????? ??????????????? ????????? ??? ????????? notice ????????? ??????
		  if(product.getP_amount() < cart_amount) { 
			  return new ModelAndView("/common/notice");
		  }
		  
		  CartVO cartVO = new CartVO();
		  cartVO.setMem_num(mem_num);
		  cartVO.setP_no(p_no); 
		  cartVO.setCart_amount(cart_amount);
		  ModelAndView mav = new ModelAndView();
			  
		  mav.setViewName("orderNow");
		  mav.addObject("cartVO", cartVO);
		  mav.addObject("member",member);
		  mav.addObject("product",product);
		  return mav;
		  
	  }
	  
	  //????????????????????? -> ??????????????? -> ??????
	  @PostMapping("/shop/orderNow.do")
	  public String insertDirectOrder(HttpSession session,OrderVO orderVO, OrderDetailVO orderDetailVO,int p_no, int cart_amount) {
		  DeliveryVO deliveryVO = new DeliveryVO();
		  ProductVO productVO = new ProductVO();
		  Integer mem_num = (Integer)session.getAttribute("mem_num");		  
		  
		  //???????????? ?????? (yyyymmdd_??????6??????)
		  Calendar cal = Calendar.getInstance();
		  int year = cal.get(Calendar.YEAR);
		  String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		  String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		  String subNum = "";
			 
		  for(int i = 1; i <= 6; i ++) {
			  subNum += (int)(Math.random() * 10);
		  }
			 
		  String orderNo = ymd + "_" + subNum;

		  orderVO.setOrder_no(orderNo); //????????????
		  orderVO.setMem_num(mem_num); //????????????
		  
		  
		  deliveryVO.setOrder_no(orderNo);
		  
		  orderDetailVO.setOrder_no(orderNo);
		  orderDetailVO.setOrder_d_amount(cart_amount);
		  
		  //??????????????? insert, ????????????????????? insert, ??????????????? insert, ?????? ?????? update
		  orderService.insertDirectOrder(orderVO, orderDetailVO); 
		  
		  return "redirect:/shop/orderResult.do";
	  }
	  
	  //?????????????????????
	  @RequestMapping("/shop/orderResult.do")
	  public String resultOrder() {
		  return "orderResult";
	  }
	  
	  //?????????????????????
	  @RequestMapping("/shop/orderList.do") 
	  public ModelAndView listOrder(HttpSession session,
			  						@RequestParam(value="pageNum",defaultValue="1") int currentPage){
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put("mem_num", mem_num);
		  
		 int count = orderService.selectAllOrderCount(mem_num);
		  
		  PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "orderList.do");
			
		  map.put("start", page.getStartCount());
		  map.put("end", page.getEndCount());
		  
		  List<OrderListVO> list = orderService.selectAllOrder(map);
		  
		  ModelAndView mav = new ModelAndView();
		  mav.addObject("list",list);
		 mav.addObject("count",count);
		  mav.addObject("pagingHtml",page.getPagingHtml());
		  mav.setViewName("orderList");
		  return mav; 
	  }
	  
	  //?????? ?????? ?????????
	  @RequestMapping("/shop/orderDetail.do")
	  public ModelAndView detailOrder(HttpSession session, @RequestParam String order_no) {
		 
		 List<OrderAllVO> listProduct = orderService.selectOrderDetailProduct(order_no);
		 OrderAllVO order = orderService.selectOrderDetailInfo(order_no);
		 
		 ModelAndView  mav = new ModelAndView();
		 
		 mav.setViewName("orderDetail");
		 mav.addObject("listProduct", listProduct);
		 mav.addObject("order",order);
		 return mav;
	  }
		 
	  
	  //?????????????????????
	  @RequestMapping("/shop/orderCancel.do")
	  public ModelAndView cancelOrder(HttpSession session,
			  						@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put("mem_num", mem_num);
		  
		  //?????? ??? ??????
		  int count = orderService.selectCancelOrderCount(mem_num);
			
		  PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "orderCancel.do");
		
		  map.put("start", page.getStartCount());
		  map.put("end", page.getEndCount());
		  
		  
		  List<OrderListVO> list = orderService.selectCancelOrder(map);
		 
		  ModelAndView mav = new ModelAndView();
		  mav.setViewName("orderCancel");
		  mav.addObject("list",list);
		  mav.addObject("count",count);
		  mav.addObject("pagingHtml",page.getPagingHtml());
		  return mav;
	  }
	  
	  //?????????????????????
	  @RequestMapping("/shop/orderExchange.do")
	  public ModelAndView exchangeOrder(HttpSession session,
			  							@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
		  
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put("mem_num", mem_num);
		  
		  int count = orderService.selectExchageOrderCount(mem_num);
		  PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "orderCancel.do");
		  map.put("start", page.getStartCount());
		  map.put("end", page.getEndCount());
		  
		  List<OrderListVO> list = orderService.selectExchageOrder(map);
		 
		  ModelAndView mav = new ModelAndView();
		  mav.setViewName("orderExchange");
		  mav.addObject("list",list);
		  mav.addObject("count",count);
		  mav.addObject("pagingHtml",page.getPagingHtml());
		  
		  return mav;
	  }
	  
	  //?????????????????????
	  @RequestMapping("/shop/orderRefund.do")
	  public ModelAndView refundOrder(HttpSession session,@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put("mem_num", mem_num);
		  int count = orderService.selectRefundOrderCount(mem_num);
		  
		  PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "orderCancel.do");
		  map.put("start", page.getStartCount());
		  map.put("end", page.getEndCount());
				  
		  List<OrderListVO> list = orderService.selectRefundOrder(map);
		 
		  ModelAndView mav = new ModelAndView();
		  mav.setViewName("refundExchange");
		  mav.addObject("list",list);
		  mav.addObject("count",count);
		  mav.addObject("pagingHtml",page.getPagingHtml());
		  return mav;
	  }
	  
	  
	  
	  //???????????????????????????
	  @RequestMapping("/shop/orderConfirm.do")
	  public ModelAndView confirmOrder(HttpSession session,@RequestParam(value="pageNum",defaultValue="1") int currentPage) {
		  Integer mem_num = (Integer)session.getAttribute("mem_num");
		  Map<String,Object> map = new HashMap<String,Object>();
		  map.put("mem_num", mem_num);
		  
		  int count = orderService.selectConfirmOrderCount(mem_num);
		  PagingUtil page = new PagingUtil(currentPage, count, rowCount, pageCount, "orderCancel.do");
		  map.put("start", page.getStartCount());
				  map.put("end", page.getEndCount());
		  List<OrderListVO> list = orderService.selectConfirmOrder(map);
		  
		 
		  ModelAndView mav = new ModelAndView();
		  mav.setViewName("orderConfirm");
		  mav.addObject("list",list);
		  mav.addObject("count",count);
		  mav.addObject("pagingHtml",page.getPagingHtml());
		  return mav;
	  } 
	  
	  //??????????????????(????????????->??????)
	  @ResponseBody
	  @RequestMapping("/shop/updateOrderCancel.do")
	  public Map<String,String> updateOrderCancel(HttpSession session, DeliveryVO delivery){
		 Map<String,String> map=new HashMap<String,String>();
		 Integer mem_num = (Integer)session.getAttribute("mem_num");
		
		 if(mem_num == null) {
			 map.put("result", "logout");
		 }else {
			 deliveryService.updateOrderDeilveryCancel(delivery.getOrder_no());
			  //?????? ?????? ?????? ???, ????????? ???????????? ?????? orderDetail?????? ?????????
			  List<OrderDetailVO> orderList = orderDetailService.selectOrderDetail(delivery.getOrder_no());
			  
			  //?????? ?????? ??????
			  for(OrderDetailVO vo : orderList) {
				  productService.productAmountPlusUpdate(vo.getOrder_d_amount(), vo.getP_no());
			  }
			 map.put("result", "success");
		 }
		 return map;
	  }
	  
	  //??????????????????(????????????->????????????)
	  @ResponseBody
	  @RequestMapping("/shop/updateOrderConfirm.do")
	  public Map<String,String> updateOrderConfirm(HttpSession session, DeliveryVO delivery){
		 Map<String,String> map=new HashMap<String,String>();
		 Integer mem_num = (Integer)session.getAttribute("mem_num");
		
		 if(mem_num == null) {
			 map.put("result", "logout");
		 }else {
			 deliveryService.updateOrderDeilveryConfirm(delivery.getOrder_no());
			 map.put("result", "success");
		 }
		 return map;
	  }
	  
	  //??????????????????(????????????->??????)
	  @ResponseBody
	  @RequestMapping("/shop/updateOrderRefund.do")
	  public Map<String,String> updateOrderRefund(HttpSession session, DeliveryVO delivery){
		 Map<String,String> map=new HashMap<String,String>();
		 Integer mem_num = (Integer)session.getAttribute("mem_num");
		
		 if(mem_num == null) {
			 map.put("result", "logout");
		 }else {
			 deliveryService.updateOrderDeilveryRefund(delivery.getOrder_no());
			  //?????? ?????? ?????? ???, ????????? ???????????? ?????? orderDetail?????? ?????????
			  List<OrderDetailVO> orderList = orderDetailService.selectOrderDetail(delivery.getOrder_no());
			  
			  //?????? ?????? ??????
			  for(OrderDetailVO vo : orderList) {
				  productService.productAmountPlusUpdate(vo.getOrder_d_amount(), vo.getP_no());
			  }
			 map.put("result", "success");
		 }
		 return map;
	  }
	  
	  //??????????????????(????????????->??????)
	  @ResponseBody
	  @RequestMapping("/shop/updateOrderExchange.do")
	  public Map<String,String> updateOrderExchange(HttpSession session, DeliveryVO delivery){
		 Map<String,String> map=new HashMap<String,String>();
		 Integer mem_num = (Integer)session.getAttribute("mem_num");
		
		 if(mem_num == null) {
			 map.put("result", "logout");
		 }else {
			 deliveryService.updateOrderDeilveryExchange(delivery.getOrder_no());
			 map.put("result", "success");
		 }
		 return map;
	  }
}
