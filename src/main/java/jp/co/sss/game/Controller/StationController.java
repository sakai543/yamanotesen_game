package jp.co.sss.game.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.game.entity.Station;
import jp.co.sss.game.form.StationForm;
import jp.co.sss.game.repository.StationRepository;

@Controller
public class StationController {

	@Autowired
	StationRepository repository;

	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}

	@RequestMapping("/stations/findAll")
	public String showStationList(Model model) {
		model.addAttribute("stations", repository.findAll());
		return "stations/station_list";
	}

	@RequestMapping("stations/getById/{id}")
	public String showStation(@PathVariable int id, Model model) {
		model.addAttribute("station", repository.getById(id));
		return "stations/station";
	}

	@RequestMapping("/stations/create/input")
	public String createInput() {
		return "stations/create_input";
	}

	@RequestMapping(path = "/stations/create/complete", method = RequestMethod.POST)
	public String createComplete(StationForm form) {
		Station station = new Station();
		station.setName(form.getName());
		repository.save(station);
		return "redirect:/stations/getById/" + station.getId();
	}

}
