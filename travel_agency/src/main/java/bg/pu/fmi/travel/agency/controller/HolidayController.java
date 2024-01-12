package bg.pu.fmi.travel.agency.controller;

import bg.pu.fmi.travel.agency.Dto.create.CreateHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.response.ResponseHolidayDTO;
import bg.pu.fmi.travel.agency.Dto.update.UpdateHolidayDTO;
import bg.pu.fmi.travel.agency.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HolidayController {

    @Autowired
    private IHolidayService service;

    @RequestMapping(method = RequestMethod.POST, value = "/holidays")
    public ResponseEntity<ResponseHolidayDTO> createHoliday(@RequestBody CreateHolidayDTO createHolidayDTO) {
        return new ResponseEntity<>(service.create(createHolidayDTO), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/holidays/{holidayId}")
    public ResponseEntity<Boolean> deleteHoliday(@PathVariable Long holidayId) {
        Boolean isDeleted = service.delete(holidayId);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/holidays")
    public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays(@RequestParam(required = false) String location,
        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
        @RequestParam(required = false) Integer duration) {
        return new ResponseEntity<>(service.findHolidayByParameters(location, startDate, duration), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/holidays/{holidayId}")
    public ResponseEntity<ResponseHolidayDTO> getHoliday(@PathVariable Long holidayId) {
        return new ResponseEntity<>(service.getHoliday(holidayId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/holidays")
    public ResponseEntity<ResponseHolidayDTO> updateHoliday(@RequestBody UpdateHolidayDTO updateHolidayDTO) {
        return new ResponseEntity<>(service.updateHoliday(updateHolidayDTO), HttpStatus.OK);
    }
}
