function toggleElement(elementId, displayStyle) {
    var element = document.getElementById(elementId);
    var current = element.currentStyle
        ? element.currentStyle['display']
        : document.defaultView.getComputedStyle(element, null).getPropertyValue('display');
    element.style.display = (current == 'none' ? displayStyle : 'none');
}

function toggle(toggleId) {
    var toggle = document.getElementById ? document.getElementById(toggleId) : document.all[toggleId];
    toggle.textContent = toggle.innerHTML == '\u25b6' ? '\u25bc' : '\u25b6';
}

var optionsPie = {
    segmentShowStroke: true,
    segmentStrokeColor: "#fff",
    segmentStrokeWidth: 2,
    percentageInnerCutout: 50,
    animationSteps: 100,
    animationEasing: "easeOutBounce",
    animateRotate: true,
    animateScale: false,
}

var optionsRake = {
    segmentShowStroke: false,
    animateScale: true
}

function bugTooltip(id){
    $("#"+id).popover({
		placement: 'right',
		html: true,
		delay: { "show": 0, "hide": 1500 },
		trigger: 'hover'
	}).mouseover();
}	

