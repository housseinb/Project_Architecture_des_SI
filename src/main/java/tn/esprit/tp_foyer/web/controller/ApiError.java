package tn.esprit.tp_foyer.web.controller;

import java.time.Instant;

public record ApiError(int status, String message, Instant timestamp) {
}
