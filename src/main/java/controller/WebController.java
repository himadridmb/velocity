package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {

	@Autowired
    private FeedService feedService;

    @RequestMapping("/feeds")
    public String list(ModelMap model) {
        model.put("feeds", feedService.getFeeds());
        return "list";
    }

    @RequestMapping("/feeds/{id}")
    public String detail(@PathVariable(value = "id") Integer feedId, ModelMap model) {
        model.put("feed", feedService.getFeedById(feedId));
        return "detail";
    }
}

